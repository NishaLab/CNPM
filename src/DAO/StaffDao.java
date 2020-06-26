/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lemony
 */
public class StaffDao extends DAO {

    public StaffDao() {
        super();
    }

    public boolean checkLogin(Staff s) {
        boolean result = false;
        String sql = "SELECT name, position FROM tblstaff WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getUserName());
            ps.setString(2, s.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setName(rs.getString("name"));
                s.setPositon(rs.getString("position"));
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
