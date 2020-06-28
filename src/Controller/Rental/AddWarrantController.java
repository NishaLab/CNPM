/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.Warrant;
import DAO.WarrantDao;
import View.Rental.AddWarrantViewFrm;
import View.Rental.AddNewWarrantFrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        setAddWarrantAction();
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

    public void setAddWarrantAction() {
        JLabel add = this.frame.getAddLabel();
        DefaultTableModel wtb = (DefaultTableModel) this.frame.getWarrantTable().getModel();
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddNewWarrantFrm anwf = new AddNewWarrantFrm();
                frame.setVisible(false);
                anwf.setVisible(true);
                JButton add = anwf.getAddBtt();
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Warrant war = new Warrant();
                        war.setType(anwf.getWarrantType().getSelectedItem().toString());
                        try {
                            war.setValue(Integer.parseInt(anwf.getValue().getText()));
                        } catch (NumberFormatException f) {
                            JOptionPane.showMessageDialog(null, "Value Must Be Interger");
                            return;
                        }
                        war.setDesc(anwf.getDesc().getText());
                        war.setClient(frame.getClient());
                        try {
                            WarrantDao dao = new WarrantDao();
                            dao.addWarrant(war);
                            wtb.addRow(war.toObject());
                            anwf.dispose();
                            frame.setVisible(true);
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                    }
                });
                JButton back = anwf.getBackBtt();
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(true);
                        anwf.dispose();
                    }
                });
            }
        });

    }
}
