/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.CarClassification;

/**
 *
 * @author LEGION
 */
public class CarClassificationDao extends DAO {

    public CarClassification getCarClassById(int key) {
        CarClassification classs = new CarClassification();
        String sql = "Select * from tblcarclassification where id = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            conn.commit();
            if (rs.next()) {
                classs.setId(rs.getInt("id"));
                classs.setName(rs.getString("name"));
                classs.setDesc(rs.getString("desc"));
                return classs;
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception f) {
                f.printStackTrace();
            }
        }

        return classs;
    }

    public boolean addCarClassification(CarClassification key) {
        String warrant = "INSERT INTO tblcarclassification(name, desc) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(warrant);
            ps.setString(1, key.getName());
            ps.setString(2, key.getDesc());
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
