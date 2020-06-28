/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Model.Car;

/**
 *
 * @author LEGION
 */
public class CarDao extends DAO {

    public ArrayList<Car> searchCar(Date receivedDate, Date returnDate, String key, int type, int brand) {
        ArrayList<Car> res = new ArrayList<Car>();
        CarTypeDao typeDao = new CarTypeDao();
        CarClassificationDao classDao = new CarClassificationDao();
        CarBrandDao brandDao = new CarBrandDao();
        String sql = "Select * from tblcar where if(?<>0,tblCarType_id = ?,true) AND if(?<>0,tblCarClassification_id = ?,true) AND NOT (state = 'Maintained') AND name LIKE ? AND id NOT IN(\n"
                + "Select tblcar_id from tblbookedcar\n"
                + "WHERE (receivedDate < ? AND returnDate > ?) \n"
                + "OR(receivedDate < ? AND returnDate > ?)\n"
                + "OR(receivedDate > ? AND returnDate < ?))\n";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.Timestamp sqlcheckin = new java.sql.Timestamp(receivedDate.getTime());
            java.sql.Timestamp sqlcheckout = new java.sql.Timestamp(returnDate.getTime());
            ps.setInt(1, type);
            ps.setInt(2, type);
            ps.setInt(3, brand);
            ps.setInt(4, type);
            ps.setString(5, "%" + key + "%");
            ps.setTimestamp(6, sqlcheckin);
            ps.setTimestamp(7, sqlcheckin);
            ps.setTimestamp(8, sqlcheckout);
            ps.setTimestamp(9, sqlcheckout);
            ps.setTimestamp(10, sqlcheckin);
            ps.setTimestamp(11, sqlcheckout);
//            ps.setTimestamp(12, sqlcheckin);
//            ps.setTimestamp(13, sqlcheckout);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setName(rs.getString("name"));
                car.setPrice(rs.getInt("price"));
                car.setBrand(brandDao.getCarBrandById(rs.getInt("brand")));
                car.setDesc(rs.getString("desc"));
                car.setState(rs.getString("state"));
                car.setRegPlate(rs.getString("reg_plate"));
                car.setClasss(classDao.getCarClassById(rs.getInt("tblCarClassification_id")));
                car.setType(typeDao.getCarTypeById(rs.getInt("tblCarType_id")));
                res.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public boolean addCar(Car c, int key) {
        String warrant = "INSERT INTO tblcontract(name,price,state,desc,reg_plate,tblCarType_id,tblCarClassification_id,tblStore_id) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(warrant);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getPrice());
            ps.setString(3, c.getState());
            ps.setString(4, c.getDesc());
            ps.setString(5, c.getRegPlate());
            ps.setInt(6, c.getType().getId());
            ps.setInt(7, c.getClasss().getId());
            ps.setInt(8, key);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Car getCar(int id){
        Car res = new Car();
        CarTypeDao typeDao = new CarTypeDao();
        CarClassificationDao classDao = new CarClassificationDao();
        CarBrandDao brandDao = new CarBrandDao();
        String sql = "select * from tblcar where id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                res.setId(rs.getInt("id"));
                res.setName(rs.getString("name"));
                res.setPrice(rs.getInt("price"));
                res.setState(rs.getString("state"));
                res.setDesc(rs.getString("desc"));
                res.setRegPlate(rs.getString("reg_plate"));
                res.setBrand(brandDao.getCarBrandById(rs.getInt("brand")));
                res.setType(typeDao.getCarTypeById(rs.getInt("tblCarType_id")));
                res.setClasss(classDao.getCarClassById(rs.getInt("tblCarClassification_id")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        System.out.println(res.getId()+" "+res.getName()+" "+res.getRegPlate());
        return res;
    }
}
