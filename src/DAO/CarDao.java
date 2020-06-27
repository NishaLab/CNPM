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
        int count = 0;
        String typeSQL = "";
        if (type != 0) {
            typeSQL = " tblCarType_id = ? ";
            count++;
        }
        String brandSQL = "";
        if (brand != 0) {
            brandSQL = " tblCarClassification_id = ? ";
            count++;
        }
        String querry = "";
        if (!typeSQL.isEmpty() && !brandSQL.isEmpty()) {
            querry = typeSQL + " And " + brandSQL + " AND ";
        } else if (typeSQL.isEmpty() && brandSQL.isEmpty()) {
            querry = "";
        } else {
            querry = typeSQL + " " + brandSQL + " " + "AND ";
        }
        String sql = "Select * from tblcar where" + querry + " NOT (state = 'Maintained') AND name LIKE ? AND id NOT IN(\n"
                + "Select tblcar_id from tblbookedcar\n"
                + "WHERE (receivedDate > ? AND returnDate > ?) \n"
                + "OR(receivedDate < ? AND returnDate < ?)\n"
                + "OR(receivedDate > ? AND returnDate < ?)\n"
                + "OR(receivedDate < ? AND returnDate > ?)) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.Timestamp sqlcheckin = new java.sql.Timestamp(receivedDate.getTime());
            java.sql.Timestamp sqlcheckout = new java.sql.Timestamp(returnDate.getTime());
            if (count == 2) {
                ps.setInt(1, type);
                ps.setInt(2, brand);
            } else if (count == 1) {
                if (brandSQL.isEmpty()) {
                    ps.setInt(1, type);
                } else {
                    ps.setInt(1, brand);
                }
            }
            ps.setString(count + 1, "%" + key + "%");
            ps.setTimestamp(count + 2, sqlcheckin);
            ps.setTimestamp(count + 3, sqlcheckout);
            ps.setTimestamp(count + 4, sqlcheckin);
            ps.setTimestamp(count + 5, sqlcheckout);
            ps.setTimestamp(count + 6, sqlcheckin);
            ps.setTimestamp(count + 7, sqlcheckout);
            ps.setTimestamp(count + 8, sqlcheckin);
            ps.setTimestamp(count + 9, sqlcheckout);
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
}
