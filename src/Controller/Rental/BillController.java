/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.Contract;
import Model.Bill;
import DAO.ContractDao;
import DAO.BillDao;
import View.Rental.BillViewFrm;
import View.Rental.SearchCarViewFrm;
import View.Rental.ReceptionistViewFrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LEGION
 */
public class BillController {

    private BillViewFrm frame;

    public BillController(BillViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setUp();
        setConfirmAction();
        setCancelAction();
    }

    public void setUp() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        Contract contract = this.frame.getContract();
        JTextField client = this.frame.getClientName();
        client.setText(contract.getClient().getName());
        client.setEditable(false);
        JTextField staff = this.frame.getStaffField();
        staff.setText(contract.getStaff().getName());
        staff.setEditable(false);
        JTextField amount = this.frame.getTotal();
        amount.setText(formatter.format(this.frame.getDeposit()));
        amount.setEditable(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        JTextField date = this.frame.getDate();
        date.setText(sdf.format(new Date()));
        date.setEditable(false);
        this.frame.getPenalty().setEditable(false);
    }

    public void setConfirmAction() {
        JButton confirm = this.frame.getAddBtt();
        Contract contract = this.frame.getContract();
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BillDao billDao = new BillDao();
                    Bill bill = new Bill();
                    bill.setContract(contract);
                    bill.setNote(frame.getNote().getText().trim());
                    bill.setPaymentDate(frame.getDate().getText());
                    bill.setPaymentType(frame.getPaymentType().getSelectedItem().toString());
                    bill.setAmount(Float.parseFloat(frame.getTotal().getText().replaceAll(",", "")));
                    bill.setPenaltyAmount(0);
                    bill.setStaff(frame.getStaff());
                    System.out.println(bill);
                    ContractDao contractDao = new ContractDao();
                    contractDao.addContract(contract);
                    if (billDao.addBill(bill)) {
                        JOptionPane.showMessageDialog(null, "Rent Car Success", "Success", 1);
                    }
                    ReceptionistViewFrm rep = new ReceptionistViewFrm(frame.getStaff());
                    frame.dispose();
                    rep.setVisible(true);

                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        });
    }

    public void setCancelAction() {
        JButton cancel = this.frame.getBackBtt();
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to cancel current contract,all data will be lost?",
                        "Pick", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == JOptionPane.YES_OPTION) {
                }
                ReceptionistViewFrm rep = new ReceptionistViewFrm(frame.getStaff());
                frame.dispose();
                rep.setVisible(true);
            }
        });
    }
}
