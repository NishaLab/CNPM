/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import static DAO.DAO.conn;
import Model.Contract;
import Model.BookedCar;
import Model.ContractWarrant;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class ContractDao extends DAO {

    public boolean addContract(Contract c) {
        String contract = "INSERT INTO tblcontract(bookingDate, state, tblStaff_id, tblClient_id) VALUES(?,?,?,?)";
        String bookedRoom = "INSERT INTO tblbookedcar(receivedDate,returnDate,penAmount,totalprice,tblCar_id,tblContract_id)VALUES(?,?,?,?,?,?)";
        String conWarrant = "INSERT INTO tblcontractwarrant(checkin,checkout,tblWarrant_id,tblContract_id) VALUES(?,?,?,?)";
        String updateCar = "UPDATE `tblcar` SET `state` = 'Rented' WHERE (`id` = ?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(contract, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date sqldate = new Date(c.getBookingDate().getTime());
            ps.setDate(1, sqldate);
            ps.setBoolean(2, c.isState());
            ps.setInt(3, c.getStaff().getId());
            ps.setInt(4, c.getClient().getId());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                c.setId(generatedKeys.getInt(1));
                for (BookedCar bc : c.getCar()) {
                    try {
                        ps = conn.prepareStatement(bookedRoom, Statement.RETURN_GENERATED_KEYS);
                        java.sql.Timestamp sqlreceived = new java.sql.Timestamp(bc.getReceivedDate().getTime());
                        java.sql.Timestamp sqlreturn = new java.sql.Timestamp(bc.getReturnDate().getTime());
                        ps.setTimestamp(1, sqlreceived);
                        ps.setTimestamp(2, sqlreturn);
                        ps.setFloat(3, bc.getPenAmount());
                        ps.setFloat(4, bc.getTotalPrice());
                        ps.setInt(5, bc.getCar().getId());
                        ps.setInt(6, c.getId());
                        ps.executeUpdate();
                        generatedKeys = ps.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            bc.setId(generatedKeys.getInt(1));
                        }
                        ps = conn.prepareStatement(updateCar);
                        ps.setInt(1, bc.getCar().getId());
                        ps.executeUpdate();
                    } catch (Exception f) {
                        f.printStackTrace();
                        try {
                            conn.rollback();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }

                }
                for (ContractWarrant cw : c.getConWarrant()) {
                    try {
                        ps = conn.prepareStatement(conWarrant);
                        java.sql.Date sqlcheckin = new Date(cw.getCheckIn().getTime());
                        java.sql.Date sqlcheckout = new Date(cw.getCheckOut().getTime());
                        ps.setDate(1, sqlcheckin);
                        ps.setDate(2, sqlcheckout);
                        ps.setInt(3, cw.getWarrant().getId());
                        ps.setInt(4, c.getId());
                        ps.executeUpdate();
                    } catch (Exception f) {
                        f.printStackTrace();
                        try {
                            conn.rollback();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception f) {
                f.printStackTrace();
                return false;
            }
            return false;
        }
        return true;
    }

}
