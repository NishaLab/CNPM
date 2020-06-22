/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import javax.swing.JFrame;
import DAO.ClientDao;
import Model.Client;
import View.Rental.SearchClientViewFrm;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public class AddClientController {

    public SearchClientViewFrm frame;

    public AddClientController(SearchClientViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setActionSearch();
        setActionConfirm();
    }

    public void setActionSearch() {
        JButton search = this.frame.getSearchButton();
        JTextField name = this.frame.getSearchField();
        JScrollPane tp = this.frame.getTablePanel();
        DefaultTableModel ctb = (DefaultTableModel) this.frame.getjTable1().getModel();
        ClientDao dao = new ClientDao();
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    public void setActionConfirm() {
        JButton confirm = this.frame.getConfirmButton();
        JTable ctb = this.frame.getjTable1();
        Client client = this.frame.getClient();
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = ctb.getSelectedRow();
                    client.setId(Integer.parseInt(ctb.getValueAt(row, 0).toString()));
                    client.setName(ctb.getValueAt(row, 1).toString());
                    client.setCCCD(ctb.getValueAt(row, 2).toString());
                    client.setAddress(ctb.getValueAt(row, 3).toString());
                    client.setPhone(ctb.getValueAt(row, 4).toString());
                    client.setLicense(ctb.getValueAt(row, 5).toString());
                    client.setType(ctb.getValueAt(row, 6).toString());
                    System.out.println(client);
                } catch (Exception f) {
                    f.printStackTrace();

                }
            }
        });
    }
}
