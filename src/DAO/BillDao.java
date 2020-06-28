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
        String sql = "INSERT INTO tblbill (amount, paymentType, paymentDate, note, tblContract_id, tblStaff_id) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, bill.getAmount());
            ps.setString(2, bill.getPaymentType());
            ps.setString(3, bill.getPaymentDate());
            ps.setString(4, bill.getNote());
            ps.setInt(5, bill.getContract().getId());
            ps.setInt(6, bill.getStaff().getId());
            ps.executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Bill> getAllBillByStaffId(int key) {
        ArrayList<Bill> res = new ArrayList<>();
        ContractDao contract = new ContractDao();
        String billSql = "SELECT * FROM tblbill WHERE tblStaff_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(billSql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setAmount(rs.getFloat("amount"));
                bill.setPaymentType(rs.getString("paymentType"));
                bill.setPaymentDate(rs.getString("paymentDate"));
                bill.setNote(rs.getString("note"));
                bill.setContract(contract.getContractById(rs.getInt("tblContract_id")));
                res.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

}
