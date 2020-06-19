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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

/**
 *
 * @author LEGION
 */
public class ContractDao extends DAO {

    public boolean addContract(Contract c) {
        String contract = "INSERT INTO tblcontract(bookingDate, state, tblStaff_id, tblClient_id) VALUES(?,?,?,?)";
        String bookedRoom = "INSERT INTO tblbookedroom(receivedDate,returnDate,penAmount,tblCar_id,tblContract_id)VALUES(?,?,?,?,?)";
        String conWarrant = "INSERT INTO tblcontractwarrant(checkin,checkout,tblWarrant_id,tblContract_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(contract);
            java.sql.Date sqldate = new Date(c.getBookingDate().getTime());
            ps.setDate(1, sqldate);
            ps.setBoolean(2, c.isState());
            ps.setInt(3, c.getStaff().getId());
            ps.setInt(3, c.getClient().getId());
            ps.executeQuery();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                c.setId(generatedKeys.getInt(1));
                for (BookedCar bc : c.getCar()) {
                    ps = conn.prepareStatement(contract);
                    java.sql.Date sqlreceived = new Date(bc.getReceivedDate().getTime());
                    java.sql.Date sqlreturn = new Date(bc.getReturnDate().getTime());
                    ps.setDate(1, sqlreceived);
                    ps.setDate(2, sqlreturn);
                    ps.setFloat(3, bc.getPenAmount());
                    ps.setInt(4, bc.getCar().getId());
                    ps.setInt(5, c.getId());
                    ps.executeUpdate();
                    generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        bc.setId(generatedKeys.getInt(1));
                    }
                    for (ContractWarrant cw : c.getConWarrant()) {
                        ps = conn.prepareStatement(contract);
                        java.sql.Date sqlcheckin = new Date(cw.getCheckIn().getTime());
                        java.sql.Date sqlcheckout = new Date(cw.getCheckOut().getTime());
                        ps.setDate(1, sqlcheckin);
                        ps.setDate(2, sqlcheckout);
                        ps.setInt(3, cw.getWarrant().getId());
                        ps.setInt(4, c.getId());
                        ps.executeUpdate();
                    }
                }
            }
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
