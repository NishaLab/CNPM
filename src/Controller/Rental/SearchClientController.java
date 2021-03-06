/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import javax.swing.JFrame;
import DAO.ClientDao;
import Model.BookedCar;
import Model.Car;
import Model.CarBrand;
import Model.CarClassification;
import Model.CarType;
import Model.Client;
import Model.ContractWarrant;
import Model.Penalty;
import Model.Staff;
import View.Rental.SearchClientViewFrm;
import View.Rental.ContractViewFrm;
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
import View.Rental.AddClientViewFrm;
import java.util.Date;

/**
 *
 * @author LEGION
 */
public class SearchClientController {

    public SearchClientViewFrm frame;

    public SearchClientController(SearchClientViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setActionSearch();
        setAddClientAction();
    }

    public void setActionSearch() {
        JLabel search = this.frame.getSearchLabel();
        JTextField name = this.frame.getSearchField();
        JScrollPane tp = this.frame.getTablePanel();
        DefaultTableModel ctb = (DefaultTableModel) this.frame.getjTable1().getModel();
        ClientDao dao = new ClientDao();
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ctb.setRowCount(0);
                    String client = name.getText().trim();
                    ArrayList<Client> listClient = dao.searchClient(client);
                    for (Client client1 : listClient) {
                        ctb.addRow(client1.toObject());
                    }
                } catch (Exception f) {
                    f.printStackTrace();

                }
            }

        });
    }
    
    public void setAddClientAction() {
        JLabel add = this.frame.getAddLabel();
        DefaultTableModel ctb = (DefaultTableModel) this.frame.getjTable1().getModel();
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                add.setOpaque(true);
//                add.setBackground(Color.DARK_GRAY);
//                add.setForeground(Color.CYAN);
                frame.setVisible(false);
                AddClientViewFrm reg = new AddClientViewFrm();
                reg.setVisible(true);
                JButton ok = reg.getAddBtt();
                ClientDao dao = new ClientDao();
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Client client = new Client();
                        client.setName(reg.getTenkh().getText());
                        client.setCCCD(reg.getCccd().getText());
                        client.setAddress(reg.getAddress().getText());
                        client.setLicense(reg.getLicense().getText());
                        client.setPhone(reg.getPhoneNUM().getText());
                        client.setType(reg.getClientType().getSelectedItem().toString());
                        try {
                            dao.addClient(client);
                            ctb.addRow(client.toObject());
                            reg.dispose();
                            frame.setVisible(true);
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                    }
                });
                JButton back = reg.getBackBtt();
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reg.dispose();
                        frame.setVisible(true);
                    }
                });
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                add.setOpaque(false);
//                add.setBackground(Color.WHITE);
//                add.setForeground(Color.BLACK);
            }
        });
    }
}
