/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.Warrant;
import DAO.WarrantDao;
import View.Rental.AddWarrantViewFrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public class AddWarrantController {

    private AddWarrantViewFrm frame;

    public AddWarrantController(AddWarrantViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setUp();
        addButtonAction();
    }

    public void setUp() {
        DefaultTableModel wtb = (DefaultTableModel) this.frame.getWarrantTable().getModel();
        wtb.setRowCount(0);
        WarrantDao dao = new WarrantDao();
        ArrayList<Warrant> warrant = dao.getAllWarrantByClient(this.frame.getClient());
        for (Warrant warrant1 : warrant) {
            wtb.addRow(warrant1.toObject());
        }
    }

    public void addButtonAction() {
        JButton add = this.frame.getAddBtt();
        DefaultTableModel wtb = (DefaultTableModel) this.frame.getWarrantTable().getModel();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Warrant war = new Warrant();
                war.setType(frame.getWarrantType().getSelectedItem().toString());
                try {
                    war.setValue(Integer.parseInt(frame.getValue().getText()));
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Value Must Be Interger");
                    return;
                }
                war.setDesc(frame.getDesc().getText());
                war.setClient(frame.getClient());
                try {
                    WarrantDao dao = new WarrantDao();
                    dao.addWarrant(war);
                    wtb.addRow(war.toObject());
                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        });
    }
}
