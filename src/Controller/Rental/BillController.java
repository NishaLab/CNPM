/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.Contract;
import Model.Bill;
import DAO.ContractDao;
import View.Rental.BillViewFrm;
import java.text.DecimalFormat;
import javax.swing.JLabel;

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
    }
}
