/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Bill;
import Model.Client;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class BillDao extends DAO {

    public boolean addBill(Bill bill) {
        String sql = "INSERT INTO `tblbill` (`amount`, `paymentType`, `paymentDate`, `note`,tblContract_id,tblStaff_id) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, bill.getAmount());
            ps.setString(2, bill.getPaymentType());
            ps.setString(3, bill.getPaymentDate());
            ps.setString(4, bill.getNote());
            ps.setInt(5, bill.getContract().getId());
            ps.setInt(6, bill.getStaff().getId());

            ps.executeUpdate();

            //get id of the new inserted client
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                bill.setId(generatedKeys.getInt(1));
            }
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
