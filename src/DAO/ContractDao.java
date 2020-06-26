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
import Model.*;
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

    public Contract getContractById(int key) {
        Contract c = null;
        ArrayList<BookedCar> listbc = new ArrayList<BookedCar>();
        ArrayList<ContractWarrant> listcw = new ArrayList<ContractWarrant>();
        ArrayList<Penalty> listpen = new ArrayList<Penalty>();

        String contract = "SELECT * FROM tblcontract WHERE id = ?";
        String bookedcar = "SELECT * FROM tblbookedcar WHERE tblcontract_id = ?";
        String contractW = "SELECT * FROM tblcontractwarrant WHERE tblcontract_id = ?";
        String staff = "SELECT * FROM tblstaff WHERE id = ?";
        String client = "SELECT * FROM tblclient WHERE id = ?";
        String car = "SELECT * FROM tblcar WHERE id = ?";
        String penalty = "SELECT * FROM tblpenalty WHERE tblbookedcar_id = ?";
        String catalog = "SELECT * FROM tbldamagecatalog WHERE id = ?";
        String warrant = "SELECT * FROM tblwarrant WHERE id = ?";
        String type = "SELECT * FROM tblcartype WHERE id = ?";
        String classs = "SELECT * FROM tblcarclassification WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(contract);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Contract();
                c.setId(rs.getInt("id"));
                c.setBookingDate(rs.getTimestamp("bookingDate"));
                c.setState(Boolean.parseBoolean(rs.getString("state")));

                ps = conn.prepareStatement(staff);
                ps.setInt(1, rs.getInt("tblstaff_id"));
                ResultSet staffrs = ps.executeQuery();
                if (staffrs.next()) {
                    Staff s = new Staff();
                    s.setId(staffrs.getInt("id"));
                    s.setName(staffrs.getString("name"));
                    s.setPositon(staffrs.getString("position"));
                    s.setUserName(staffrs.getString("username"));
                    s.setPassword(staffrs.getString("password"));
                    c.setStaff(s);
                }

                ps = conn.prepareStatement(client);
                ps.setInt(1, rs.getInt("tblclient_id"));
                ResultSet clientrs = ps.executeQuery();
                Client cl = new Client();
                if (clientrs.next()) {
                    cl.setId(clientrs.getInt("id"));
                    cl.setName(clientrs.getString("name"));
                    cl.setCCCD(clientrs.getString("CCCD"));
                    cl.setAddress(clientrs.getString("address"));
                    cl.setPhone(clientrs.getString("phone"));
                    cl.setLicense(clientrs.getString("license"));
                    cl.setType(clientrs.getString("type"));
                    c.setClient(cl);
                }

                ps = conn.prepareStatement(bookedcar);
                ps.setInt(1, c.getId());
                ResultSet bookedcarRs = ps.executeQuery();
                while (bookedcarRs.next()) {
                    BookedCar bc = new BookedCar();
                    bc.setId(bookedcarRs.getInt("id"));
                    bc.setReceivedDate(bookedcarRs.getTimestamp("receivedDate"));
                    bc.setReturnDate(bookedcarRs.getTimestamp("returnDate"));

                    int car_id = bookedcarRs.getInt("tblcar_id");
                    ps = conn.prepareStatement(car);
                    ps.setInt(1, car_id);
                    ResultSet carRs = ps.executeQuery();
                    if (carRs.next()) {
                        Car x = new Car();
                        x.setId(carRs.getInt("id"));
                        x.setPrice((int) carRs.getFloat("price"));
                        x.setName(carRs.getString("name"));
                        x.setDesc(carRs.getString("desc"));
                        x.setState(carRs.getString("state"));
                        x.setRegPlate(carRs.getString("reg_plate"));

                        ps = conn.prepareStatement(type);
                        ps.setInt(1, carRs.getInt("tblcartype_id"));
                        ResultSet typeRs = ps.executeQuery();
                        if (typeRs.next()) {
                            CarType ct = new CarType();
                            ct.setId(typeRs.getInt("id"));
                            ct.setName(typeRs.getString("name"));
                            ct.setDesc(typeRs.getString("desc"));
                            x.setType(ct);
                        }

                        ps = conn.prepareStatement(classs);
                        ps.setInt(1, carRs.getInt("tblcarclassification_id"));
                        ResultSet classRs = ps.executeQuery();
                        if (classRs.next()) {
                            CarClassification ct = new CarClassification();
                            ct.setId(classRs.getInt("id"));
                            ct.setName(classRs.getString("name"));
                            ct.setDesc(classRs.getString("desc"));
                            x.setClasss(ct);
                        }

                        bc.setCar(x);
                    }

                    ps = conn.prepareStatement(penalty);
                    ps.setInt(1, bc.getId());
                    ResultSet penrs = ps.executeQuery();
                    while (penrs.next()) {
                        Penalty p = new Penalty();
                        p.setQuantity(penrs.getInt("quantity"));

                        ps = conn.prepareStatement(catalog);
                        ps.setInt(1, penrs.getInt("tbldamagecatalog_id"));
                        ResultSet dcRs = ps.executeQuery();
                        if (dcRs.next()) {
                            DamageCatalog dc = new DamageCatalog();
                            dc.setId(dcRs.getInt("id"));
                            dc.setFee(Integer.parseInt(dcRs.getString("fee")));
                            p.setDamage(dc);
                        }
                        p.setAmount(p.getDamage().getFee() * p.getQuantity());
                        listpen.add(p);
                    }
                    long penAmount = 0;
                    for (Penalty listpen1 : listpen) {
                        penAmount += listpen1.getAmount();
                    }
                    bc.setPenAmount(penAmount);
                    long duration = (bc.getReturnDate().getTime() - bc.getReceivedDate().getTime()) / (60 * 60 * 24 * 1000);
                    bc.setTotalPrice(duration * bc.getCar().getPrice() + bc.getPenAmount());
                    bc.setPen(listpen);
                    listbc.add(bc);
                }
                c.setCar(listbc);

                ps = conn.prepareStatement(contractW);
                ps.setInt(1, c.getId());
                ResultSet cwRs = ps.executeQuery();
                while (cwRs.next()) {
                    ContractWarrant cw = new ContractWarrant();
                    cw.setCheckIn(cwRs.getTimestamp("checkin"));
                    cw.setCheckOut(cwRs.getTimestamp("checkout"));

                    ps = conn.prepareStatement(warrant);
                    ps.setInt(1, cwRs.getInt("tblwarrant_id"));
                    ResultSet wRs = ps.executeQuery();
                    if (wRs.next()) {
                        Warrant w = new Warrant();
                        w.setId(wRs.getInt("id"));
                        w.setType(wRs.getString("type"));
                        w.setValue(wRs.getInt("value"));
                        w.setDesc(wRs.getString("desc"));
                        w.setClient(cl);
                        cw.setWarrant(w);
                    }
                    listcw.add(cw);
                }
                c.setConWarrant(listcw);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public ArrayList<Contract> getContractByStaffId(int key) {
        ArrayList<Contract> res = new ArrayList<>();
        ArrayList<BookedCar> listbc = new ArrayList<BookedCar>();
        ArrayList<ContractWarrant> listcw = new ArrayList<ContractWarrant>();
        ArrayList<Penalty> listpen = new ArrayList<Penalty>();

        String contract = "SELECT * FROM tblcontract WHERE tblStaff_id = ?";
        String bookedcar = "SELECT * FROM tblbookedcar WHERE tblcontract_id = ?";
        String contractW = "SELECT * FROM tblcontractwarrant WHERE tblcontract_id = ?";
        String staff = "SELECT * FROM tblstaff WHERE id = ?";
        String client = "SELECT * FROM tblclient WHERE id = ?";
        String car = "SELECT * FROM tblcar WHERE id = ?";
        String penalty = "SELECT * FROM tblpenalty WHERE tblbookedcar_id = ?";
        String catalog = "SELECT * FROM tbldamagecatalog WHERE id = ?";
        String warrant = "SELECT * FROM tblwarrant WHERE id = ?";
        String type = "SELECT * FROM tblcartype WHERE id = ?";
        String classs = "SELECT * FROM tblcarclassification WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(contract);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contract c = new Contract();
                c.setId(rs.getInt("id"));
                c.setBookingDate(rs.getTimestamp("bookingDate"));
                c.setState(Boolean.parseBoolean(rs.getString("state")));

                ps = conn.prepareStatement(staff);
                ps.setInt(1, rs.getInt("tblstaff_id"));
                ResultSet staffrs = ps.executeQuery();
                if (staffrs.next()) {
                    Staff s = new Staff();
                    s.setId(staffrs.getInt("id"));
                    s.setName(staffrs.getString("name"));
                    s.setPositon(staffrs.getString("position"));
                    s.setUserName(staffrs.getString("username"));
                    s.setPassword(staffrs.getString("password"));
                    c.setStaff(s);
                }

                ps = conn.prepareStatement(client);
                ps.setInt(1, rs.getInt("tblclient_id"));
                ResultSet clientrs = ps.executeQuery();
                Client cl = new Client();
                if (clientrs.next()) {
                    cl.setId(clientrs.getInt("id"));
                    cl.setName(clientrs.getString("name"));
                    cl.setCCCD(clientrs.getString("CCCD"));
                    cl.setAddress(clientrs.getString("address"));
                    cl.setPhone(clientrs.getString("phone"));
                    cl.setLicense(clientrs.getString("license"));
                    cl.setType(clientrs.getString("type"));
                    c.setClient(cl);
                }

                ps = conn.prepareStatement(bookedcar);
                ps.setInt(1, c.getId());
                ResultSet bookedcarRs = ps.executeQuery();
                while (bookedcarRs.next()) {
                    BookedCar bc = new BookedCar();
                    bc.setId(bookedcarRs.getInt("id"));
                    bc.setReceivedDate(bookedcarRs.getTimestamp("receivedDate"));
                    bc.setReturnDate(bookedcarRs.getTimestamp("returnDate"));

                    int car_id = bookedcarRs.getInt("tblcar_id");
                    ps = conn.prepareStatement(car);
                    ps.setInt(1, car_id);
                    ResultSet carRs = ps.executeQuery();
                    if (carRs.next()) {
                        Car x = new Car();
                        x.setId(carRs.getInt("id"));
                        x.setPrice((int) carRs.getFloat("price"));
                        x.setName(carRs.getString("name"));
                        x.setDesc(carRs.getString("desc"));
                        x.setState(carRs.getString("state"));
                        x.setRegPlate(carRs.getString("reg_plate"));

                        ps = conn.prepareStatement(type);
                        ps.setInt(1, carRs.getInt("tblcartype_id"));
                        ResultSet typeRs = ps.executeQuery();
                        if (typeRs.next()) {
                            CarType ct = new CarType();
                            ct.setId(typeRs.getInt("id"));
                            ct.setName(typeRs.getString("name"));
                            ct.setDesc(typeRs.getString("desc"));
                            x.setType(ct);
                        }

                        ps = conn.prepareStatement(classs);
                        ps.setInt(1, carRs.getInt("tblcarclassification_id"));
                        ResultSet classRs = ps.executeQuery();
                        if (classRs.next()) {
                            CarClassification ct = new CarClassification();
                            ct.setId(classRs.getInt("id"));
                            ct.setName(classRs.getString("name"));
                            ct.setDesc(classRs.getString("desc"));
                            x.setClasss(ct);
                        }

                        bc.setCar(x);
                    }

                    ps = conn.prepareStatement(penalty);
                    ps.setInt(1, bc.getId());
                    ResultSet penrs = ps.executeQuery();
                    while (penrs.next()) {
                        Penalty p = new Penalty();
                        p.setQuantity(penrs.getInt("quantity"));

                        ps = conn.prepareStatement(catalog);
                        ps.setInt(1, penrs.getInt("tbldamagecatalog_id"));
                        ResultSet dcRs = ps.executeQuery();
                        if (dcRs.next()) {
                            DamageCatalog dc = new DamageCatalog();
                            dc.setId(dcRs.getInt("id"));
                            dc.setFee(Integer.parseInt(dcRs.getString("fee")));
                            p.setDamage(dc);
                        }
                        p.setAmount(p.getDamage().getFee() * p.getQuantity());
                        listpen.add(p);
                    }
                    long penAmount = 0;
                    for (Penalty listpen1 : listpen) {
                        penAmount += listpen1.getAmount();
                    }
                    bc.setPenAmount(penAmount);
                    long duration = (bc.getReturnDate().getTime() - bc.getReceivedDate().getTime()) / (60 * 60 * 24 * 1000);
                    bc.setTotalPrice(duration * bc.getCar().getPrice() + bc.getPenAmount());
                    bc.setPen(listpen);
                    listbc.add(bc);
                }
                c.setCar(listbc);

                ps = conn.prepareStatement(contractW);
                ps.setInt(1, c.getId());
                ResultSet cwRs = ps.executeQuery();
                while (cwRs.next()) {
                    ContractWarrant cw = new ContractWarrant();
                    cw.setCheckIn(cwRs.getTimestamp("checkin"));
                    cw.setCheckOut(cwRs.getTimestamp("checkout"));

                    ps = conn.prepareStatement(warrant);
                    ps.setInt(1, cwRs.getInt("tblwarrant_id"));
                    ResultSet wRs = ps.executeQuery();
                    if (wRs.next()) {
                        Warrant w = new Warrant();
                        w.setId(wRs.getInt("id"));
                        w.setType(wRs.getString("type"));
                        w.setValue(wRs.getInt("value"));
                        w.setDesc(wRs.getString("desc"));
                        w.setClient(cl);
                        cw.setWarrant(w);
                    }
                    listcw.add(cw);
                }
                c.setConWarrant(listcw);
                res.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<Client> getClientByName(String key) {
        ArrayList<Client> listcl = new ArrayList<Client>();
        ArrayList<Contract> res = new ArrayList<Contract>();
        ArrayList<BookedCar> listbc = new ArrayList<BookedCar>();
        ArrayList<ContractWarrant> listcw = new ArrayList<ContractWarrant>();
        ArrayList<Penalty> listpen = new ArrayList<Penalty>();

        String contract = "SELECT * FROM tblcontract WHERE tblStaff_id = ?";
        String bookedcar = "SELECT * FROM tblbookedcar WHERE tblcontract_id = ?";
        String contractW = "SELECT * FROM tblcontractwarrant WHERE tblcontract_id = ?";
        String staff = "SELECT * FROM tblstaff WHERE id = ?";
        String client = "SELECT * FROM tblclient WHERE name LIKE ?";
        String car = "SELECT * FROM tblcar WHERE id = ?";
        String penalty = "SELECT * FROM tblpenalty WHERE tblbookedcar_id = ?";
        String catalog = "SELECT * FROM tbldamagecatalog WHERE id = ?";
        String warrant = "SELECT * FROM tblwarrant WHERE id = ?";
        String type = "SELECT * FROM tblcartype WHERE id = ?";
        String classs = "SELECT * FROM tblcarclassification WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(client);
            ps.setString(1, "%" + key + "%");
            ResultSet clientrs = ps.executeQuery();
            while (clientrs.next()) {
                Client cl = new Client();
                cl.setId(clientrs.getInt("id"));
                cl.setName(clientrs.getString("name"));
                cl.setCCCD(clientrs.getString("CCCD"));
                cl.setAddress(clientrs.getString("address"));
                cl.setPhone(clientrs.getString("phone"));
                cl.setLicense(clientrs.getString("license"));
                cl.setType(clientrs.getString("type"));
                listcl.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return listcl;
    }

    public ArrayList<Contract> getContractByClientId(int key) {
        ArrayList<Contract> res = new ArrayList<>();
        ArrayList<BookedCar> listbc = new ArrayList<BookedCar>();
        ArrayList<ContractWarrant> listcw = new ArrayList<ContractWarrant>();
        ArrayList<Penalty> listpen = new ArrayList<Penalty>();

        String contract = "SELECT * FROM tblcontract WHERE tblclient_id = ?";
        String bookedcar = "SELECT * FROM tblbookedcar WHERE tblcontract_id = ?";
        String contractW = "SELECT * FROM tblcontractwarrant WHERE tblcontract_id = ?";
        String staff = "SELECT * FROM tblstaff WHERE id = ?";
        String client = "SELECT * FROM tblclient WHERE id = ?";
        String car = "SELECT * FROM tblcar WHERE id = ?";
        String penalty = "SELECT * FROM tblpenalty WHERE tblbookedcar_id = ?";
        String catalog = "SELECT * FROM tbldamagecatalog WHERE id = ?";
        String warrant = "SELECT * FROM tblwarrant WHERE id = ?";
        String type = "SELECT * FROM tblcartype WHERE id = ?";
        String classs = "SELECT * FROM tblcarclassification WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(contract);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contract c = new Contract();
                c.setId(rs.getInt("id"));
                c.setBookingDate(rs.getTimestamp("bookingDate"));
                c.setState(Boolean.parseBoolean(rs.getString("state")));

                ps = conn.prepareStatement(staff);
                ps.setInt(1, rs.getInt("tblstaff_id"));
                ResultSet staffrs = ps.executeQuery();
                if (staffrs.next()) {
                    Staff s = new Staff();
                    s.setId(staffrs.getInt("id"));
                    s.setName(staffrs.getString("name"));
                    s.setPositon(staffrs.getString("position"));
                    s.setUserName(staffrs.getString("username"));
                    s.setPassword(staffrs.getString("password"));
                    c.setStaff(s);
                }

                ps = conn.prepareStatement(client);
                ps.setInt(1, key);
                ResultSet clientrs = ps.executeQuery();
                Client cl = new Client();
                if (clientrs.next()) {
                    cl.setId(clientrs.getInt("id"));
                    cl.setName(clientrs.getString("name"));
                    cl.setCCCD(clientrs.getString("CCCD"));
                    cl.setAddress(clientrs.getString("address"));
                    cl.setPhone(clientrs.getString("phone"));
                    cl.setLicense(clientrs.getString("license"));
                    cl.setType(clientrs.getString("type"));
                    c.setClient(cl);
                }

                ps = conn.prepareStatement(bookedcar);
                ps.setInt(1, c.getId());
                ResultSet bookedcarRs = ps.executeQuery();
                while (bookedcarRs.next()) {
                    BookedCar bc = new BookedCar();
                    bc.setId(bookedcarRs.getInt("id"));
                    bc.setReceivedDate(bookedcarRs.getTimestamp("receivedDate"));
                    bc.setReturnDate(bookedcarRs.getTimestamp("returnDate"));

                    int car_id = bookedcarRs.getInt("tblcar_id");
                    ps = conn.prepareStatement(car);
                    ps.setInt(1, car_id);
                    ResultSet carRs = ps.executeQuery();
                    if (carRs.next()) {
                        Car x = new Car();
                        x.setId(carRs.getInt("id"));
                        x.setPrice((int) carRs.getFloat("price"));
                        x.setName(carRs.getString("name"));
                        x.setDesc(carRs.getString("desc"));
                        x.setState(carRs.getString("state"));
                        x.setRegPlate(carRs.getString("reg_plate"));

                        ps = conn.prepareStatement(type);
                        ps.setInt(1, carRs.getInt("tblcartype_id"));
                        ResultSet typeRs = ps.executeQuery();
                        if (typeRs.next()) {
                            CarType ct = new CarType();
                            ct.setId(typeRs.getInt("id"));
                            ct.setName(typeRs.getString("name"));
                            ct.setDesc(typeRs.getString("desc"));
                            x.setType(ct);
                        }

                        ps = conn.prepareStatement(classs);
                        ps.setInt(1, carRs.getInt("tblcarclassification_id"));
                        ResultSet classRs = ps.executeQuery();
                        if (classRs.next()) {
                            CarClassification ct = new CarClassification();
                            ct.setId(classRs.getInt("id"));
                            ct.setName(classRs.getString("name"));
                            ct.setDesc(classRs.getString("desc"));
                            x.setClasss(ct);
                        }

                        bc.setCar(x);
                    }

                    ps = conn.prepareStatement(penalty);
                    ps.setInt(1, bc.getId());
                    ResultSet penrs = ps.executeQuery();
                    while (penrs.next()) {
                        Penalty p = new Penalty();
                        p.setQuantity(penrs.getInt("quantity"));

                        ps = conn.prepareStatement(catalog);
                        ps.setInt(1, penrs.getInt("tbldamagecatalog_id"));
                        ResultSet dcRs = ps.executeQuery();
                        if (dcRs.next()) {
                            DamageCatalog dc = new DamageCatalog();
                            dc.setId(dcRs.getInt("id"));
                            dc.setFee(Integer.parseInt(dcRs.getString("fee")));
                            p.setDamage(dc);
                        }
                        p.setAmount(p.getDamage().getFee() * p.getQuantity());
                        listpen.add(p);
                    }
                    long penAmount = 0;
                    for (Penalty listpen1 : listpen) {
                        penAmount += listpen1.getAmount();
                    }
                    bc.setPenAmount(penAmount);
                    long duration = (bc.getReturnDate().getTime() - bc.getReceivedDate().getTime()) / (60 * 60 * 24 * 1000);
                    bc.setTotalPrice(duration * bc.getCar().getPrice() + bc.getPenAmount());
                    bc.setPen(listpen);
                    listbc.add(bc);
                }
                c.setCar(listbc);

                ps = conn.prepareStatement(contractW);
                ps.setInt(1, c.getId());
                ResultSet cwRs = ps.executeQuery();
                while (cwRs.next()) {
                    ContractWarrant cw = new ContractWarrant();
                    cw.setCheckIn(cwRs.getTimestamp("checkin"));
                    cw.setCheckOut(cwRs.getTimestamp("checkout"));

                    ps = conn.prepareStatement(warrant);
                    ps.setInt(1, cwRs.getInt("tblwarrant_id"));
                    ResultSet wRs = ps.executeQuery();
                    if (wRs.next()) {
                        Warrant w = new Warrant();
                        w.setId(wRs.getInt("id"));
                        w.setType(wRs.getString("type"));
                        w.setValue(wRs.getInt("value"));
                        w.setDesc(wRs.getString("desc"));
                        w.setClient(cl);
                        cw.setWarrant(w);
                    }
                    listcw.add(cw);
                }
                c.setConWarrant(listcw);
                res.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
