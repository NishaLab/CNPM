/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author LEGION
 */
import Model.Warrant;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WarrantDao extends DAO {

    public boolean addWarrant(Warrant w) {
        String warrant = "INSERT INTO tblcontract(type, value, desc, tblClient_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(warrant);
            ps.setString(1, w.getType());
            ps.setInt(2, w.getValue());
            ps.setString(3, w.getDesc());
            ps.setInt(4, w.getClient().getId());
            ps.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
