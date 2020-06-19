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
        String sql = "Select * from tblcar where tblCarType_id = ? and tblCarClassification_id = ?  AND name LIKE ? "
                + "AND id NOT IN(SELECT id FROM tblbookedcar WHERE receivedDate > ? AND returnDate < ?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.Date sqlcheckin = new java.sql.Date(receivedDate.getTime());
            java.sql.Date sqlcheckout = new java.sql.Date(returnDate.getTime());
            ps.setInt(1, type);
            ps.setInt(2, brand);
            ps.setString(3, "%" + key + "%");
            ps.setDate(4, sqlcheckin);
            ps.setDate(5, sqlcheckout);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setName(rs.getString("name"));
                car.setPrice(rs.getInt("price"));
                car.setBrand(rs.getString("brand"));
                car.setDesc(rs.getString("desc"));
                car.setState(rs.getString("state"));
                car.setClasss(classDao.getCarClassById(rs.getInt("tblCarClassification_id")));
                car.setType(typeDao.getCarTypeById(rs.getInt("tblCarType_id")));
                res.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
