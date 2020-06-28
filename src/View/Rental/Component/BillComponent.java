/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental.Component;

import java.util.ArrayList;
import Model.Bill;
import DAO.BillDao;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public class BillComponent extends javax.swing.JPanel {

    /**
     * Creates new form BillComponent
     */
    private ArrayList<Bill> bill = new ArrayList<>();

    public BillComponent() {
        initComponents();
    }

    public BillComponent(ArrayList<Bill> bill) {
        initComponents();
        this.bill = bill;
        DecimalFormat formatter = new DecimalFormat("#,###");
        DefaultTableModel btb = (DefaultTableModel) this.jTable1.getModel();
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(Color.WHITE);
        for (Bill bill1 : bill) {
            Object[] tmp;
            tmp = new Object[]{bill1.getId(),bill1.getContract().getClient().getName(), formatter.format(bill1.getAmount()),
                bill1.getPaymentType(), bill1.getPaymentDate(), bill1.getNote()};
            btb.addRow(tmp);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client", "Amount", "Payment Type", "Payment Date", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setName(""); // NOI18N
        jTable1.setSelectionBackground(new java.awt.Color(93, 47, 208));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 690, 310));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
