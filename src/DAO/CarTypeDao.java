/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.CarType;

/**
 *
 * @author LEGION
 */
public class CarTypeDao extends DAO {

    public CarType getCarTypeById(int key) {
        CarType type = new CarType();
        String sql = "Select * from tblcartype where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                type.setDesc(rs.getString("desc"));
                return type;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return type;

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
