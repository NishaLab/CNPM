/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Model.CarBrandStat;
import Model.CarBrand;
import Model.CarStat;
import Model.Car;
import Model.CarType;
import java.time.LocalDate;
/**
 *
 * @author Vu Minh Duc
 */
public class CarStatDao extends DAO{
    public CarStatDao(){
        super();
    }
	public ArrayList<CarBrandStat> getCarBrandStat(Date startDate, Date endDate){
		ArrayList<CarBrandStat> result = new ArrayList<CarBrandStat>();
                 CarBrandDao cbDao = new CarBrandDao();
		String sql = "select c.id, c.name, ifnull(sum(Y.income),0) as totalIncome, ifnull(sum(Y.days),0) as totalDays, ifnull(sum(Y.rentTime),0) as totalRentTime"
                            +" from"
                            +" (select X.carid, X.brandid, count(days) as rentTime, ifnull(sum(X.income),0) as income, ifnull(sum(X.days),0) as days"
                            +" from (SELECT a.id as carid, a.brand as brandid, "
                            +" (SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate,?)) FROM tblBookedCar b"
                            +" WHERE b.returnDate > ? AND b.receivedDate < ? AND b.tblCar_id = a.id  ) as days,"
                            +" (SELECT datediff(least(b.returnDate,?),greatest(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*(b.totalprice + b.penAmount) FROM tblBookedCar b"
                            +" WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as income"
                            +" from tblCar a )as X " 
                            +" group by X.carid ) as Y, tblcarbrand c"
                            +" where Y.brandid = c.id"     
                            +" group by Y.brandid"  
                            +" order by totalIncome desc" ;          
                     
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
			
			while(rs.next()) {
				CarBrandStat cb = new CarBrandStat();
                                  CarBrand brand = cbDao.getCarBrandById(rs.getInt("id"));
				cb.setId(brand.getId());
                                  cb.setName(brand.getName());
                                  cb.setDesc(brand.getDesc());
                                  cb.setIncome(rs.getFloat("totalIncome"));
                                  cb.setTotalDay(rs.getInt("totalDays"));
                                  cb.setRentTime(rs.getInt("totalRentTime"));
				result.add(cb);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
        public ArrayList<CarStat> getDetailsBrandStat(Date startDate,Date endDate, int brandId){
            ArrayList<CarStat> result = new ArrayList<CarStat>();
            CarBrandDao cb = new CarBrandDao();
            CarTypeDao ct = new CarTypeDao();
            CarDao cd = new CarDao();
            String sql = "select 	Y.carid,  c.id as brandid, d.id as typeid ,  ifnull(sum(Y.days),0) as totalDay, ifnull(sum(Y.income),0) as totalIncome, ifnull(sum(Y.rentTime),0) as totalRentTime"
                        +" from (select X.carid, X.brandid, X.cartypeid, count(days) as rentTime, ifnull(sum(X.income),0) as income, ifnull(sum(X.days),0) as days"
                        +" from	(SELECT a.id as carid, a.brand as brandid, a.tblCarType_id as cartypeid,"
                        +" (SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate,?)) FROM tblBookedCar b"
                        +" WHERE b.returnDate > ? AND b.receivedDate < ? AND b.tblCar_id = a.id  ) as days,"
                        +" (SELECT datediff(least(b.returnDate,?),greatest(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*(b.totalprice + b.penAmount) FROM tblBookedCar b"
                        +" WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as income"
                        +" from tblCar a "
                        +" where a.brand = ? ) as X "
                        +" group by X.carid ) as Y, tblcar a, tblcarbrand c, tblcartype d"
                        +" where Y.carid=a.id and Y.brandid=c.id and Y.cartypeid=d.id"
                        +" group by Y.carid"
                        +" order by totalIncome desc";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try{
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sdf.format(endDate));
                ps.setString(2, sdf.format(startDate));
                ps.setString(3, sdf.format(startDate));
                ps.setString(4, sdf.format(endDate));
                ps.setString(5, sdf.format(endDate));
                ps.setString(6, sdf.format(startDate));
                ps.setString(7, sdf.format(startDate));
                ps.setString(8, sdf.format(endDate)); 
                ps.setInt(9, brandId);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    CarStat cs = new CarStat();
                    
                    CarBrand brand = cb.getCarBrandById(rs.getInt("brandid"));
                    CarType type = ct.getCarTypeById(rs.getInt("typeid"));
                    Car car = cd.getCar(rs.getInt("carid"));
                    cs.setId(car.getId());
                    cs.setName(car.getName());
                    cs.setRegPlate(car.getRegPlate());
                    cs.setDesc(car.getDesc());
                    cs.setBrand(brand);
                    cs.setType(type);
                    cs.setTotalDay(rs.getInt("totalDay"));
                    cs.setIncome(rs.getFloat("totalIncome"));
                    cs.setRentTime(rs.getInt("totalRentTime"));
                    result.add(cs);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return result;       
        }
        public ArrayList<CarStat> getDetailsCarStat(Date startDate,Date endDate, int carid){
            ArrayList<CarStat> result = new ArrayList<CarStat>();
            
            CarBrandDao cb = new CarBrandDao();
            CarTypeDao ct = new CarTypeDao();
            CarDao cd = new CarDao();
            
            String sql = "select	distinct X.contractid, X.carid, X.brandid, X.cartypeid, e.name as clientname, ifnull(X.days,0) as days, ifnull(X.income,0) as income, ifnull(X.PenAmount,0) as PenAmount"
                        +" from (SELECT b.tblCar_id as carid, a.brand as brandid, a.tblCarType_id as cartypeid, b.tblContract_id as contractid,"
                        +" (SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate,?)) FROM tblBookedCar b"
                        +" WHERE b.returnDate > ? AND b.receivedDate < ? and b.tblCar_id=a.id  ) as days,"
                        +" (SELECT datediff(least(b.returnDate,?),greatest(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice FROM tblBookedCar b"
                        +" WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as income,"
                        +" (SELECT datediff(least(b.returnDate,?),greatest(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*b.penAmount FROM tblBookedCar b"
                        +" WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as PenAmount"
                        +" from tblcar a, tblbookedcar b"
                        +" where b.tblCar_id= ? and b.tblCar_id=a.id ) as X, tblcar a, tblbookedcar b, tblcontract d, tblclient e, tblcarbrand f, tblcartype g"
                        +" where  X.carid=a.id and X.contractid=d.id and d.tblClient_id=e.id"
                        +" order by income desc" ;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,sdf.format(endDate));
                ps.setString(2,sdf.format(startDate));
                ps.setString(3,sdf.format(startDate));
                ps.setString(4,sdf.format(endDate));
                ps.setString(5,sdf.format(endDate));
                ps.setString(6,sdf.format(startDate));
                ps.setString(7,sdf.format(startDate));
                ps.setString(8,sdf.format(endDate));
                ps.setString(9, sdf.format(endDate));
                ps.setString(10,sdf.format(startDate));
                ps.setString(11, sdf.format(startDate));
                ps.setString(12, sdf.format(endDate));                
                ps.setInt(13,carid);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    CarStat cs = new CarStat();
                    Car car = cd.getCar(carid);
                    CarBrand brand = cb.getCarBrandById(rs.getInt("brandid"));
                    CarType type = ct.getCarTypeById(rs.getInt("cartypeid"));
                    
                    cs.setId(car.getId());
                    cs.setName(car.getName());
                    cs.setBrand(brand);
                    cs.setType(type);
                    cs.setClientName(rs.getString("clientname"));
                    cs.setRegPlate(car.getRegPlate());
                    cs.setTotalDay(rs.getInt("days"));
                    cs.setIncome(rs.getFloat("income"));
                    cs.setContractId(rs.getInt("contractid"));
                    cs.setPenAmount(rs.getFloat("PenAmount"));
                    result.add(cs);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return result;
        }
     
}
