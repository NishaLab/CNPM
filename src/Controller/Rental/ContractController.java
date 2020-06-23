/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import View.Rental.ContractViewFrm;
import Model.Contract;
import Model.ContractWarrant;
import Model.BookedCar;
import Model.Car;
import Model.Warrant;
import Model.Client;
import Model.Staff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public class ContractController {

    private ContractViewFrm frame;

    public ContractController(ContractViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        initUI();
    }

    public void initUI() {
        DefaultTableModel ctb = (DefaultTableModel) this.frame.getCarTable().getModel();
        DefaultTableModel wtb = (DefaultTableModel) this.frame.getWarrantTable().getModel();
        ctb.setRowCount(0);
        wtb.setRowCount(0);
        ArrayList<BookedCar> bc = this.frame.getBc();
        ArrayList<ContractWarrant> cw = this.frame.getCw();
        Client client = this.frame.getClient();
        Staff staff = this.frame.getStaff();
        JLabel clientName = this.frame.getClientName();
        clientName.setText(client.getName());
        JLabel staffName = this.frame.getStaffName();
        staffName.setText(staff.getName());
        long deposit = 1000000 * bc.size();
        this.frame.getDeposit().setText(deposit + "");
        long total = 0;
        for (BookedCar bookedCar : bc) {
            long days = (bookedCar.getReturnDate().getTime() - bookedCar.getReceivedDate().getTime()) / (60 * 60 * 24 * 1000);
            System.out.println(days);
            long amount = bookedCar.getCar().getPrice() * days;
            total += amount;
            Object[] tmp;
            tmp = new Object[]{bookedCar.getId(), bookedCar.getCar().getName(), bookedCar.getReceivedDate(),
                bookedCar.getReturnDate(), amount};
            ctb.addRow(tmp);
        }
        for (ContractWarrant warrant : cw) {
            Object[] tmp;
            tmp = new Object[]{warrant.getCheckIn(), warrant.getCheckOut(), warrant.getWarrant().getType(),
                warrant.getWarrant().getValue(), warrant.getWarrant().getDesc()};
        }
        total += deposit;
        this.frame.getTotal().setText(total + "");
        Date date = new Date();
        this.frame.getDate().setText(date.toString());
    }

}
