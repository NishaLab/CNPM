/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.Bill;
import DAO.BillDao;
import DAO.ContractDao;
import Model.Contract;
import java.util.ArrayList;
import View.Rental.ReceptionistViewFrm;
import View.Rental.Component.BillComponent;
import View.Rental.Component.ContractComponent;
import View.Rental.SearchCarViewFrm;
import View.login.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LEGION
 */
public class ReceptionistController {

    private ReceptionistViewFrm frame;

    public ReceptionistController(ReceptionistViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setRentCarAction();
        setBillAction();
        setContractAction();
        setLogoutAction();
    }

    public void setRentCarAction() {
        JLabel label = this.frame.getRentText();
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchCarViewFrm scvf = new SearchCarViewFrm(frame.getStaff());
                frame.dispose();
                scvf.setVisible(true);
            }
        });
    }

    public void setBillAction() {
        JLabel label = this.frame.getBillText();
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(frame.getBillSide());
                resetColor(frame.getContractSide());
                ArrayList<Bill> bill = new ArrayList<>();
                if (frame.getBill().isEmpty()) {
                    BillDao dao = new BillDao();
                    bill = dao.getAllBillByStaffId(frame.getStaff().getId());
                    frame.getMainPanel().removeAll();
                    frame.getMainPanel().setLayout(new BorderLayout());
                    frame.getMainPanel().add(new BillComponent(bill));
                    frame.getMainPanel().revalidate();
                    frame.getMainPanel().repaint();
                    frame.setBill(bill);
                } else {
                    bill = frame.getBill();
                    frame.getMainPanel().removeAll();
                    frame.getMainPanel().setLayout(new BorderLayout());
                    frame.getMainPanel().add(new BillComponent(bill));
                    frame.getMainPanel().revalidate();
                    frame.getMainPanel().repaint();
                }

            }
        });
    }

    public void setContractAction() {
        JLabel label = this.frame.getContractText();
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(frame.getContractSide());
                resetColor(frame.getBillSide());
                ArrayList<Contract> contract = new ArrayList<>();
                if (frame.getBill().isEmpty()) {
                    ContractDao dao = new ContractDao();
                    contract = dao.getContractByStaffId(frame.getStaff().getId());
                    frame.getMainPanel().removeAll();
                    frame.getMainPanel().setLayout(new BorderLayout());
                    frame.getMainPanel().add(new ContractComponent(contract));
                    frame.getMainPanel().revalidate();
                    frame.getMainPanel().repaint();
                    frame.setContract(contract);
                } else {
                    contract = frame.getContract();
                    frame.getMainPanel().removeAll();
                    frame.getMainPanel().setLayout(new BorderLayout());
                    frame.getMainPanel().add(new ContractComponent(contract));
                    frame.getMainPanel().revalidate();
                    frame.getMainPanel().repaint();
                }

            }
        });
    }

    public void setLogoutAction() {
        JLabel label = this.frame.getLogoutText();
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Login log = new Login();
               frame.dispose();
               log.setVisible(true);
            }
        });
    }

    public void setColor(JPanel panel) {
        panel.setBackground(new Color(47, 24, 107));
    }

    public void resetColor(JPanel panel) {
        panel.setBackground(new Color(85, 75, 158));
    }
}
