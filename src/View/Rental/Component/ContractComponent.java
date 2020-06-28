/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental.Component;

import Model.BookedCar;
import Model.Contract;
import Model.Car;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public class ContractComponent extends javax.swing.JPanel {

    /**
     * Creates new form ContractComponent
     */
    public ContractComponent() {
        initComponents();
    }

    public ContractComponent(ArrayList<Contract> contract) {
        initComponents();
        DecimalFormat formatter = new DecimalFormat("#,###");
        DefaultTableModel ctb = (DefaultTableModel) this.jTable1.getModel();
        jTable1.getTableHeader().setFont(new Font("Segoe Print", Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(Color.WHITE);
        for (Contract contract1 : contract) {
            Object[] tmp;
            float amount = 0;
            for (BookedCar bookedCar : contract1.getCar()) {
                amount += bookedCar.getTotalPrice();
            }
            tmp = new Object[]{contract1.getId(),contract1.getClient().getName(),formatter.format(amount),contract1.getBookingDate().toString()};
            ctb.addRow(tmp);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        detailsBtt = new keeptoo.KButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(710, 380));
        setPreferredSize(new java.awt.Dimension(710, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client", "Amount", "BookingDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(93, 47, 208));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 690, 320));

        detailsBtt.setBackground(new java.awt.Color(255, 255, 255));
        detailsBtt.setBorder(null);
        detailsBtt.setText("See Details");
        detailsBtt.setFocusPainted(false);
        detailsBtt.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        detailsBtt.setkBorderRadius(50);
        detailsBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBttActionPerformed(evt);
            }
        });
        add(detailsBtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void detailsBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsBttActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton detailsBtt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}