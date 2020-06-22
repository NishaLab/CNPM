/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import javax.swing.JFrame;
import DAO.ClientDao;
import Model.Client;
import View.Rental.AddClientViewFrm;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public class AddClientController {

    public AddClientViewFrm frame;

    public AddClientController(AddClientViewFrm frame) {
        this.frame = frame;
    }

    public void init() {

    }

    public void setConfirmButtonAction() {
        JButton ok = frame.getOkBtt();
        ClientDao dao = new ClientDao();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = new Client();
                client.setName(frame.getTenkh().getText());
                client.setCCCD(frame.getCccd().getText());
                client.setAddress(frame.getAddress().getText());
                client.setLicense(frame.getLicense().getText());
                client.setPhone(frame.getPhoneNUM().getText());
                client.setType(frame.getClientType().getSelectedItem().toString());
                dao.addClient(client);
            }
        });
    }
}
