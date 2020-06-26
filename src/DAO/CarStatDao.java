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
		String sql = "select c.name, ifnull(sum(X.income),0) as totalIncome, ifnull(sum(X.days),0) as totalDays"
                            + "from	(SELECT a.id as carid, a.brand as brandid,  "
                            + "		(SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate,?)) FROM tblBookedCar b"
                            + "			WHERE b.returnDate > ? AND b.receivedDate < ? AND b.tblCar_id = a.id  ) as days,"
                            + "		(SELECT datediff(least(b.returnDate,?),greatest(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice FROM tblBookedCar b"
                            + "			WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? ) as income"
                            + "from tblCar a "
                            + "ORDER BY income DESC ) as X, tblcarbrand c"
                            + "where X.brandid = c.id"
                            + "group by X.brandid"
                            + "order by totalIncome desc" ;
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
			
			while(rs.next()) {
				CarBrandStat cb = new CarBrandStat();
                                  CarBrand brand = cbDao.getCarBrandById(rs.getInt("id"));
				cb.setId(brand.getId());
                                  cb.setName(brand.getName());
                                  cb.setDesc(brand.getDesc());
                                  cb.setIncome(rs.getFloat("totalIncome"));
                                  cb.setTotalDay(rs.getInt("totalDays"));
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
            String sql = "select 	X.carid,  c.id as brandid, d.name as typeid,  ifnull(sum(X.days),0) as totalDay, ifnull(sum(X.income),0) as totalIncome"
                        +"from	(SELECT a.id as carid, a.brand as brandid, a.tblCarType_id as cartypeid,"
                        +"		(SELECT DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate, ?)) FROM tblBookedCar b"
                        +"			WHERE b.returnDate > ? AND b.receivedDate < ? AND b.tblCar_id = a.id  and b.tblCar_id = a.id ) as days,"
                        +"		(SELECT datediff(least(b.returnDate, ?),greatest(b.receivedDate, ? ))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice FROM tblBookedCar b"
                        +"			WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ? and b.tblCar_id = a.id ) as income"
                        +"from tblcar a, tblcarbrand c, tblcartype d"
                        +"where a.brand = ? and  a.tblCarType_id = d.id and a.brand = c.id ) as X, tblcar a, tblcarbrand c, tblcartype d"
                        +"where X.carid=a.id and X.brandid=c.id and X.cartypeid=d.id"
                        +"group by X.carid"
                        +"order by totalIncome desc" ;
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
                ps.setString(9,""+brandId);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    CarStat cs = new CarStat();
                    
                    CarBrand brand = cb.getCarBrandById(rs.getInt("brandid"));
                    CarType type = ct.getCarTypeById(rs.getInt("typeid"));
                    Car car = cd.getCar(rs.getInt("carid"));
                    
                    cs.setId(brand.getId());
                    cs.setName(car.getName());
                    cs.setDesc(car.getDesc());
                    cs.setBrand(brand);
                    cs.setType(type);
                    cs.setAmount(rs.getFloat("totalIncome"));
                    cs.setTotalDay(rs.getInt("totalDay"));
                    
                    result.add(cs);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return result;       
        }
     
}
