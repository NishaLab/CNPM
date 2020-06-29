/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import View.Rental.ContractViewFrm;
import View.Rental.AddWarrantViewFrm;
import View.Rental.BillViewFrm;
import View.Rental.SearchCarViewFrm;
import Model.Contract;
import Model.ContractWarrant;
import Model.BookedCar;
import Model.Car;
import Model.Warrant;
import Model.Client;
import Model.Staff;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        setBackLabelAction();
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
        JTextField clientName = this.frame.getClientName();
        clientName.setText(client.getName());
        clientName.setEditable(false);
        JTextField staffName = this.frame.getStaffName();
        staffName.setText(staff.getName());
        staffName.setEditable(false);
        long deposit = 1000000 * bc.size();
        this.frame.getDeposit().setText(formatter.format(deposit));
        this.frame.getDeposit().setEditable(false);
        long total = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (BookedCar bookedCar : bc) {
            long amount = 0;
            amount += bookedCar.getTotalPrice();
            total += amount;
            Object[] tmp;
            tmp = new Object[]{bookedCar.getCar().getId(), bookedCar.getCar().getName(), sdf.format(bookedCar.getReceivedDate()),
                sdf.format(bookedCar.getReturnDate()), formatter.format(amount), bookedCar.getCar().getRegPlate()};
            ctb.addRow(tmp);
        }
        for (ContractWarrant warrant : cw) {
            Object[] tmp;
            tmp = new Object[]{sdf.format(warrant.getCheckIn()), sdf.format(warrant.getCheckOut()), warrant.getWarrant().getType(),
                warrant.getWarrant().getValue(), warrant.getWarrant().getDesc()};
            wtb.addRow(tmp);
        }
        total += deposit;
        this.frame.getTotal().setText(formatter.format(total));
        this.frame.getTotal().setEditable(false);
        Date date = new Date();
        this.frame.getDate().setText(date.toString());
        this.frame.getDate().setEditable(false);
        this.frame.getCarTable().getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        this.frame.getWarrantTable().getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

    }

    public void addWarrantAction() {
        JLabel add = this.frame.getAddLabel1();
        DefaultTableModel cwtb = (DefaultTableModel) this.frame.getWarrantTable().getModel();
        Client client = this.frame.getClient();
        ArrayList<ContractWarrant> cw = this.frame.getCw();
        ArrayList<BookedCar> bc = this.frame.getBc();
        Collections.sort(bc, new Comparator<BookedCar>() {
            @Override
            public int compare(BookedCar o1, BookedCar o2) {
                return o2.getReturnDate().compareTo(o1.getReturnDate());
            }
        });
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                add.setOpaque(true);
//                add.setBackground(Color.DARK_GRAY);
//                add.setForeground(Color.CYAN);
                frame.setVisible(false);
                AddWarrantViewFrm reg = new AddWarrantViewFrm(client);
                reg.setVisible(true);
                JLabel confirm = reg.getConfrimLabel();
                confirm.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ContractWarrant con = new ContractWarrant();
                        JTable wtb = reg.getWarrantTable();
                        int row = wtb.getSelectedRow();
                        Warrant a = new Warrant();
                        a.setId(Integer.parseInt(wtb.getValueAt(row, 0).toString()));
                        a.setType(wtb.getValueAt(row, 1).toString());
                        a.setValue(Integer.parseInt(wtb.getValueAt(row, 2).toString().replaceAll(",", "")));
                        a.setDesc(wtb.getValueAt(row, 3).toString());
                        a.setClient(client);
                        con.setWarrant(a);
                        con.setCheckIn(bc.get(0).getReturnDate());
                        con.setCheckOut(bc.get(bc.size() - 1).getReceivedDate());
                        cw.add(con);
                        Object[] tmp;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        tmp = new Object[]{sdf.format(con.getCheckIn()), sdf.format(con.getCheckOut()), con.getWarrant().getType(),
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
        JLabel confirm = this.frame.getConfrimLabel1();
        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Create Contract? ",
                        "Pick", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == JOptionPane.YES_OPTION) {
                    Contract contract = new Contract();
                    contract.setBookingDate(frame.getBookingDate());
                    contract.setCar(frame.getBc());
                    contract.setConWarrant(frame.getCw());
                    contract.setAmount(Integer.parseInt(frame.getTotal().getText().replaceAll(",", "")));
                    contract.setState(true);
                    contract.setClient(frame.getClient());
                    contract.setStaff(frame.getStaff());
                    frame.dispose();
                    BillViewFrm bill = new BillViewFrm(contract, frame.getStaff());
                    bill.setVisible(true);
                }

            }
        });
    }

    public void setBackLabelAction() {
        JLabel back = this.frame.getBackLabel1();
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to go back to search car frame?\n Current Data will be lost ",
                        "Pick", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == JOptionPane.YES_OPTION) {
                    ArrayList<BookedCar> bc = frame.getBc();
                    SearchCarViewFrm scvf = new SearchCarViewFrm(frame.getStaff(), bc);
                    frame.dispose();
                    scvf.setVisible(true);
                }
            }

        });

    }

}
