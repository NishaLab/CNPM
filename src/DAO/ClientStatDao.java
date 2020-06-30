/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BookedCar;
import Model.Car;
import Model.Client;
import Model.ClientStat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Microsoft Windows
 */
public class ClientStatDao extends DAO {

    public ClientStatDao() {
        super();
    }

    public ArrayList<ClientStat> getClientStat(Date startDate, Date endDate) {
        ArrayList<ClientStat> result = new ArrayList<ClientStat>();
        ClientDao cd = new ClientDao();
        
        String sql =  " SELECT c.name, c.cccd, c.phone, c.address, ifnull(x.days,0) as totalDay, ifnull(x.income,0) as income"
                    + " FROM (SELECT a.id, a.tblClient_id,"
                    + " (SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate,?)) FROM cnpm7.tblBookedCar b "
                    + " WHERE b.returnDate > ? AND b.receivedDate < ? AND b.tblContract_id = a.id) as days, "
                    + " (SELECT (datediff(least(b.returnDate,?),greatest(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice) + b.penAmount FROM cnpm7.tblBookedCar b "
                    + " WHERE b.tblContract_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as income "
                    + " FROM cnpm7.tblContract a) as x, cnpm7.tblClient c "
                    + " WHERE X.tblClient_id = c.id " 
                    + " ORDER BY income DESC " ;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdf.format(endDate));
            ps.setString(2, sdf.format(startDate));
            ps.setString(3, sdf.format(startDate));
            ps.setString(4, sdf.format(endDate));
            ps.setString(5, sdf.format(endDate));
            ps.setString(6, sdf.format(startDate));
            ps.setString(7, sdf.format(startDate));
            ps.setString(8, sdf.format(endDate));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ClientStat cs = new ClientStat();
                Client c = cd.getClientById(rs.getInt("id"));
                cs.setId(c.getId());
                cs.setName(c.getName());
                cs.setCCCD(c.getCCCD());
                cs.setPhone(c.getPhone());
                cs.setAddress(c.getAddress());
                cs.setTotalDay(rs.getInt("totalDay"));
                cs.setTotalPayment(rs.getInt("totalPayment"));
                result.add(cs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<ClientStat> getClientStatDetails(Date startDate, Date endDate) {
        ArrayList<ClientStat> result = new ArrayList<ClientStat>();

        ClientDao cd = new ClientDao();
        ContractDao conDao = new ContractDao();
        CarDao carDao = new CarDao();
        //ArrayList<Integer> contract = conDao.getAllContractIdByClientid(key);
        //for (Integer integer : contract) {

        //}
        String sql = " select a.id, a.name as carname, b.receivedDate, b.returnDate, a.price, b.penAmount, ifnull(X.TotalDay,0) as TotalDay, ifnull(X.income,0) as income "
                    + " from (SELECT b.tblCar_id as carid, b.receivedDate, b.returnDate, b.tblContract_id as contractid, "
                    + " (SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate, ?)) FROM cnpm7.tblBookedCar b "
                    + " WHERE b.returnDate > ? AND b.receivedDate < ? and b.tblCar_id=a.id  ) as TotalDay, "
                    + " (SELECT (datediff(least(b.returnDate, ?),greatest(b.receivedDate, ?))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice) + b.penAmount FROM cnpm7.tblBookedCar b "
                    + " WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as income "
                    + " FROM cnpm7.tblcar a, cnpm7.tblBookedCar b "
                    + " WHERE  b.tblCar_id = a.id ) as X, cnpm7.tblcar a, cnpm7.tblBookedCar b, cnpm7.tblcontract d, cnpm7.tblclient e "
                    + " WHERE  X.carid = a.id and X.contractid = d.id and d.tblClient_id = e.id "
                    + " GROUP BY a.id " 
                    + " ORDER BY income DESC " ;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdf.format(endDate));
            ps.setString(2, sdf.format(startDate));
            ps.setString(3, sdf.format(startDate));
            ps.setString(4, sdf.format(endDate));
            ps.setString(5, sdf.format(endDate));
            ps.setString(6, sdf.format(startDate));
            ps.setString(7, sdf.format(startDate));
            ps.setString(8, sdf.format(endDate));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClientStat cs = new ClientStat();
                
                cs.setId(rs.getInt("Id"));
                cs.setCName(rs.getString("CarName"));
                cs.setPrice(rs.getFloat("CarPrice"));
                cs.setPen(rs.getInt("penAmount"));
                cs.setTotalDay(rs.getInt("TotalDay"));
                cs.setTotalPayment(rs.getInt("totalPayment"));
                
                result.add(cs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<BookedCar> getAllBookedCarByContractId(int id) {
        ArrayList<BookedCar> res = new ArrayList<>();
        String sql = "Select * from tblbookedcar where tblContract_id = ?";
        String carSql = "Select * from tblcar where id = ?";

        CarBrandDao brandDao = new CarBrandDao();
        CarClassificationDao classDao = new CarClassificationDao();
        CarTypeDao typeDao = new CarTypeDao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookedCar booked = new BookedCar();
                booked.setId(rs.getInt("id"));
                booked.setReceivedDate(rs.getTimestamp("receivedDate"));
                booked.setReturnDate(rs.getTimestamp("returnDate"));
                booked.setTotalPrice(rs.getFloat("totalprice"));
                booked.setPenAmount(rs.getFloat("penAmount"));
                PreparedStatement cps = conn.prepareStatement(carSql);
                cps.setInt(1, rs.getInt("tblCar_id"));
                ResultSet crs = cps.executeQuery();
                if (crs.next()) {
                    Car car = new Car();
                    car.setId(rs.getInt("id"));
                    car.setName(rs.getString("name"));
                    //car.setPrice(rs.getInt("price"));
                    //car.setBrand(brandDao.getCarBrandById(rs.getInt("brand")));
                    //car.setDesc(rs.getString("desc"));
                    //car.setState(rs.getString("state"));
                    //car.setRegPlate(rs.getString("reg_plate"));
                    car.setClasss(classDao.getCarClassById(rs.getInt("tblCarClassification_id")));
                    car.setType(typeDao.getCarTypeById(rs.getInt("tblCarType_id")));
                    booked.setCar(car);
                }
                res.add(booked);
            }
        } catch (Exception e) {
        }
        return res;
    }

    
}
