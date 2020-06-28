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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    }

    public void setUp() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        Contract contract = this.frame.getContract();
        JLabel client = this.frame.getClientName();
        client.setText(contract.getClient().getName());
        JLabel staff = this.frame.getStaffName();
        staff.setText(contract.getStaff().getName());
        JLabel amount = this.frame.getTotal();
        amount.setText(formatter.format(contract.getAmount()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JLabel date = this.frame.getDate();
        date.setText(sdf.format(new Date()));
    }

    public void setConfirmAction() {
        JLabel confirm = this.frame.getConfirmLabel();
        Contract contract = this.frame.getContract();
        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    BillDao billDao = new BillDao();
                    Bill bill = new Bill();
                    bill.setContract(contract);
                    bill.setNote(frame.getNote().getText().trim());
                    bill.setPaymentDate(frame.getDate().getText());
                    bill.setPaymentType(frame.getPayment().getSelectedItem().toString());
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
}
