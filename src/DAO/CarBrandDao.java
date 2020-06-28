/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CarBrand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author LEGION
 */
public class CarBrandDao extends DAO {
        public CarBrand getCarBrandById(int key) {
        CarBrand brand = new CarBrand();
        String sql = "Select * from tblcarbrand where id = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            conn.commit();
            if (rs.next()) {
                brand.setId(rs.getInt("id"));
                brand.setName(rs.getString("name"));
                brand.setDesc(rs.getString("desc"));
                return brand;
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception f) {
                f.printStackTrace();
            }
        }

        return brand;
    }

    public boolean addCarBrand(CarBrand key) {
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
