/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Return;

import DAO.ContractDao;
import Model.Client;
import Model.Contract;
import View.Return.ContractViewFrm;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import view.Return.SearchContractFrm;

/**
 *
 * @author Lemony
 */
public class SearchContractController {

    public SearchContractFrm frame;

    public SearchContractController(SearchContractFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setActionSearchClient();
        setActionSearchByClient();
        setActionGetContract();
    }

    private void setActionSearchClient() {
        JButton search = this.frame.getSearchByName();
        JTextField name = this.frame.getClientName();
        DefaultTableModel dtm = (DefaultTableModel) this.frame.getClientTable().getModel();
        ContractDao cd = new ContractDao();
        search.addActionListener((ActionEvent e) -> {
            try {
                dtm.setRowCount(0);
                String client = name.getText();
                ArrayList<Client> listClient = cd.getClientByName(client);
                listClient.forEach((var client1) -> {
                    System.out.println(new Object[]{client1.getName(), client1.getCCCD(), client1.getAddress(), client1.getPhone(), client1.getLicense()});
                    dtm.addRow(new Object[]{client1.getId(), client1.getName(), client1.getCCCD(), client1.getAddress(), client1.getPhone(), client1.getLicense()});
                });
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
    }

    private void setActionSearchByClient() {
        JTable table = this.frame.getClientTable();
        DefaultTableModel dtm = (DefaultTableModel) this.frame.getContractTable().getModel();
        ContractDao cd = new ContractDao();
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    dtm.setRowCount(0);
                    int row = table.getSelectedRow();
                    int key = (int) table.getModel().getValueAt(row, 0);
                    ArrayList<Contract> listContract = cd.getContractByClientId(key);
                    for (Contract contract1 : listContract) {
                        dtm.addRow(new Object[]{contract1.getId(),contract1.getBookingDate(), contract1.isState(), contract1.getStaff().getName(), contract1.getClient().getName()});
                    }

                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
    }

    public void setActionGetContract() {
        JTable table = this.frame.getContractTable();

        ContractDao cd = new ContractDao();
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvt) {
                JTable table = (JTable) mouseEvt.getSource();
                Point point = mouseEvt.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvt.getClickCount() == 2 && table.getSelectedRow() != -1) {
//                    Contract c = cd.getContractById(key);
//                    new ContractViewFrm(c.getClient(), c.getStaff(), c.getCar(), c.getConWarrant()).setVisible(true);
                    System.out.println("hello clgt");
                }
            }
        });
        this.frame.dispose();
    }
}
