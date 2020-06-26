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
import Model.Client;
import Model.Warrant;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WarrantDao extends DAO {

    public boolean addWarrant(Warrant warrant) {
        String sql = "INSERT INTO `tblwarrant` (`type`, `value`, `desc`, `tblClient_id`) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, warrant.getType());
            ps.setInt(2, warrant.getValue());
            ps.setString(3, warrant.getDesc());
            ps.setInt(4, warrant.getClient().getId());

            ps.executeUpdate();

            //get id of the new inserted client
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                warrant.setId(generatedKeys.getInt(1));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Warrant> getAllWarrantByClient(Client key) {
        ArrayList<Warrant> res = new ArrayList<>();
        String sql = "Select * from tblwarrant where tblClient_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Warrant warrant = new Warrant();
                warrant.setId(rs.getInt("id"));
                warrant.setType(rs.getString("type"));
                warrant.setDesc(rs.getString("desc"));
                warrant.setValue(rs.getInt("value"));
                warrant.setClient(key);
                res.add(warrant);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
        return res;
    }

}
