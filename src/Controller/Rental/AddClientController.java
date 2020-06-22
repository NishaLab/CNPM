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
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
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
        setActionSearch();
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
}
