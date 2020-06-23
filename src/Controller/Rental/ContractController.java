/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import View.Rental.ContractViewFrm;
import View.Rental.AddWarrantViewFrm;
import View.Rental.BillViewFrm;
import Model.Contract;
import Model.ContractWarrant;
import Model.BookedCar;
import Model.Car;
import Model.Warrant;
import Model.Client;
import Model.Staff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
        addWarrantAction();
        addConfirmLabelAction();
    }

    public void initUI() {
        DecimalFormat formatter = new DecimalFormat("#,###");
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
        this.frame.getDeposit().setText(formatter.format(deposit));
        long total = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (BookedCar bookedCar : bc) {
            long days = (bookedCar.getReturnDate().getTime() - bookedCar.getReceivedDate().getTime()) / (60 * 60 * 24 * 1000) + 1;
            System.out.println(days);
            long amount = bookedCar.getCar().getPrice() * days;
            total += amount;
            Object[] tmp;
            tmp = new Object[]{bookedCar.getCar().getId(), bookedCar.getCar().getName(), sdf.format(bookedCar.getReceivedDate()),
                sdf.format(bookedCar.getReturnDate()), formatter.format(amount), bookedCar.getCar().getRegPlate()};
            ctb.addRow(tmp);
        }
        for (ContractWarrant warrant : cw) {
            Object[] tmp;
            tmp = new Object[]{warrant.getCheckIn(), warrant.getCheckOut(), warrant.getWarrant().getType(),
                warrant.getWarrant().getValue(), warrant.getWarrant().getDesc()};
            wtb.addRow(tmp);
        }
        total += deposit;
        this.frame.getTotal().setText(formatter.format(total));
        Date date = new Date();
        this.frame.getDate().setText(date.toString());
    }

    public void addWarrantAction() {
        JLabel add = this.frame.getAddLabel1();
        DefaultTableModel cwtb = (DefaultTableModel) this.frame.getWarrantTable().getModel();
        Client client = this.frame.getClient();
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                add.setOpaque(true);
//                add.setBackground(Color.DARK_GRAY);
//                add.setForeground(Color.CYAN);
                frame.setVisible(false);
                AddWarrantViewFrm reg = new AddWarrantViewFrm(client);
                reg.setVisible(true);
                JLabel confirm = reg.getConfirmLabel();
                confirm.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ContractWarrant con = new ContractWarrant();
                        JTable wtb = reg.getWarrantTable();
                        int row = wtb.getSelectedRow();
                        Warrant a = new Warrant();
                        a.setId(Integer.parseInt(wtb.getValueAt(row, 0).toString()));
                        a.setType(wtb.getValueAt(row, 1).toString());
                        a.setValue(Integer.parseInt(wtb.getValueAt(row, 3).toString().replaceAll(",", "")));
                        a.setDesc(wtb.getValueAt(row, 3).toString());
                        a.setClient(client);
                        con.setWarrant(a);
                        con.setCheckIn(new Date());
                        Object[] tmp;
                        tmp = new Object[]{con.getCheckIn(), con.getCheckOut(), con.getWarrant().getType(),
                            con.getWarrant().getValue(), con.getWarrant().getDesc()};
                        cwtb.addRow(tmp);
                        reg.setVisible(false);
                        frame.setVisible(true);
                    }
                });

            }
        });
    }

    public void addConfirmLabelAction() {
        JLabel confirm = this.frame.getConfirmLabel();
        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Contract contract = new Contract();
                contract.setBookingDate(frame.getBookingDate());
                contract.setCar(frame.getBc());
                contract.setConWarrant(frame.getCw());
                contract.setAmount(Integer.parseInt(frame.getTotal().getText().replaceAll(",", "")));
                contract.setState(true);
                contract.setClient(frame.getClient());
                contract.setStaff(frame.getStaff());
                frame.dispose();
                BillViewFrm bill = new BillViewFrm(contract);
                bill.setVisible(true);
            }
        });
    }

}
