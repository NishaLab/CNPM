/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.CarType;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class CarTypeDao extends DAO {

    public CarType getCarTypeById(int key) {
        CarType type = new CarType();
        String sql = "Select * from tblcartype where id = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            conn.commit();
            if (rs.next()) {
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                type.setDesc(rs.getString("desc"));
                return type;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception f) {
                f.printStackTrace();
            }
        }

        return type;

    }

    public ArrayList<CarType> getAllCarType() {
        ArrayList<CarType> res = new ArrayList();
        String sql = "Select * from tblcartype";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CarType type = new CarType();
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                type.setDesc(rs.getString("desc"));
                res.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;

    }

    public boolean addCarType(CarType key) {
        String warrant = "INSERT INTO tblcontract(name, desc) VALUES(?,?)";
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
