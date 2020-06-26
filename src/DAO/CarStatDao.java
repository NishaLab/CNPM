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
import Model.CarStat;
/**
 *
 * @author Vu Minh Duc
 */
public class CarStatDao extends DAO{
    public CarStatDao(){
        super();
    }
	public ArrayList<CarStat> getCarStat(Date startDate, Date endDate){
                 CarClassificationDao classDao = new CarClassificationDao();
                 CarTypeDao typeDao = new CarTypeDao();
                 CarBrandDao brandDao = new CarBrandDao();
		ArrayList<CarStat> result = new ArrayList<CarStat>();
		String sql = "SELECT a.id, a.name, a.price, a.brand, a.desc, a.tblCarType_id, a.tblCarClassification_id, a.tblStore_id "
				+ "(SELECT SUM(DATEDIFF(LEAST(b.returnDate, ?), GREATEST(b.receivedDate, ?))) FROM tblBookedCar b "
				+ "WHERE b.id = a.id AND b.returnDate > ? AND b.receivedDate < ? GROUP BY b.id) as days,"
				+ " (SELECT SUM(DATEDIFF(LEAST(b.checkout, ?), GREATEST(b.checkin, ?))*b.totalprice) FROM tblBookedCar b "
				+ "WHERE b.id = a.id AND b.checkout > ? AND b.checkin < ? GROUP BY b.id) as income "
				+ " FROM tblRoom a ORDER BY income DESC, brand DESC";
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
				CarStat r = new CarStat();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
                                  r.setBrand(brandDao.getCarBrandById(rs.getInt("brand")));
                                  r.setDesc(rs.getString("desc"));
				r.setType(typeDao.getCarTypeById(rs.getInt("tblCarType_id")));
                                  r.setClasss(classDao.getCarClassById(rs.getInt("tblCarClassification_id")));
				r.setTotalDay(rs.getInt("days"));
				r.setAmount(rs.getFloat("income"));
				result.add(r);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
