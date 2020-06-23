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
import java.util.ArrayList;
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
        ArrayList<BookedCar> bc = this.frame.getBc();
        Client client = this.frame.getClient();
        Staff staff = this.frame.getStaff();
        JLabel clientName = this.frame.getClientName();
        clientName.setText(client.getName());
        JLabel staffName = this.frame.getStaffName();
        staffName.setText(staff.getName());
        for (BookedCar bookedCar : bc) {
            Object[] tmp;
            tmp = new Object[]{bookedCar.getId(),bookedCar.getCar().getName(),bookedCar.getReceivedDate(),bookedCar.getReturnDate()};
        }
    }
}
