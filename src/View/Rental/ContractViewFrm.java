/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental;

import Model.BookedCar;
import Model.Client;
import Model.Staff;
import Model.ContractWarrant;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author LEGION
 */
public class ContractViewFrm extends javax.swing.JFrame {

    private ArrayList<BookedCar> bc = new ArrayList<>();
    private ArrayList<ContractWarrant> cw = new ArrayList<>();
    private Client client;
    private Staff staff;

    public ContractViewFrm(Client client, Staff staff, ArrayList<BookedCar> bc, ArrayList<ContractWarrant> cw) {
        initComponents();
        this.bc = bc;
        this.cw = cw;
        this.client = client;
        this.staff = staff;
    }

    /**
     * Creates new form ContractViewFrm
     */
    public ContractViewFrm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        carLabel = new javax.swing.JLabel();
        carScrollPane = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        warrantLabel = new javax.swing.JLabel();
        warrantScrollPane = new javax.swing.JScrollPane();
        warrantTable = new javax.swing.JTable();
        staffName = new javax.swing.JLabel();
        staffLabel1 = new javax.swing.JLabel();
        clientLabel2 = new javax.swing.JLabel();
        clientName = new javax.swing.JLabel();
        depositLabel = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        confirmLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        addLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        titleLabel.setText("Draft Contract");

        dateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dateLabel.setText("Booking Date:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Date");

        carLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        carLabel.setText("Booked Car:");

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Received Date", "Return Date", "Total Price"
            }
        ));
        carScrollPane.setViewportView(carTable);

        warrantLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        warrantLabel.setText("Warrant:");

        warrantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Check In", "Check Out", "Type", "Value", "Description"
            }
        ));
        warrantScrollPane.setViewportView(warrantTable);

        staffName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        staffName.setText("Staff Name");

        staffLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        staffLabel1.setText("Staff:");

        clientLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clientLabel2.setText("Client:");

        clientName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clientName.setText("Client Name");

        depositLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        depositLabel.setText("Deposit Fee:");

        total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total.setText("...");

        depositField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositFieldActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalLabel.setText("Total:");

        confirmLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmLabel.setText("Confirm");

        backLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backLabel.setText("Go Back");

        addLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addLabel1.setText("Add Warrant");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(57, 57, 57)
                        .addComponent(addLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(confirmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(warrantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warrantScrollPane))
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clientLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171)
                                .addComponent(staffLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(157, 157, 157))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(depositLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(depositField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(carLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(warrantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warrantScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total)
                    .addComponent(totalLabel))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depositFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContractViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContractViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContractViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContractViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContractViewFrm().setVisible(true);
            }
        });
    }

    public ArrayList<BookedCar> getBc() {
        return bc;
    }

    public void setBc(ArrayList<BookedCar> bc) {
        this.bc = bc;
    }

    public ArrayList<ContractWarrant> getCw() {
        return cw;
    }

    public void setCw(ArrayList<ContractWarrant> cw) {
        this.cw = cw;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public JLabel getAddLabel1() {
        return addLabel1;
    }

    public void setAddLabel1(JLabel addLabel1) {
        this.addLabel1 = addLabel1;
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public void setBackLabel(JLabel backLabel) {
        this.backLabel = backLabel;
    }

    public JLabel getCarLabel() {
        return carLabel;
    }

    public void setCarLabel(JLabel carLabel) {
        this.carLabel = carLabel;
    }

    public JScrollPane getCarScrollPane() {
        return carScrollPane;
    }

    public void setCarScrollPane(JScrollPane carScrollPane) {
        this.carScrollPane = carScrollPane;
    }

    public JTable getCarTable() {
        return carTable;
    }

    public void setCarTable(JTable carTable) {
        this.carTable = carTable;
    }

    public JLabel getClientLabel2() {
        return clientLabel2;
    }

    public void setClientLabel2(JLabel clientLabel2) {
        this.clientLabel2 = clientLabel2;
    }

    public JLabel getClientName() {
        return clientName;
    }

    public void setClientName(JLabel clientName) {
        this.clientName = clientName;
    }

    public JLabel getConfirmLabel() {
        return confirmLabel;
    }

    public void setConfirmLabel(JLabel confirmLabel) {
        this.confirmLabel = confirmLabel;
    }

    public JLabel getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(JLabel dateLabel) {
        this.dateLabel = dateLabel;
    }

    public JTextField getDepositField() {
        return depositField;
    }

    public void setDepositField(JTextField depositField) {
        this.depositField = depositField;
    }

    public JLabel getDepositLabel() {
        return depositLabel;
    }

    public void setDepositLabel(JLabel depositLabel) {
        this.depositLabel = depositLabel;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getStaffLabel1() {
        return staffLabel1;
    }

    public void setStaffLabel1(JLabel staffLabel1) {
        this.staffLabel1 = staffLabel1;
    }

    public JLabel getStaffName() {
        return staffName;
    }

    public void setStaffName(JLabel staffName) {
        this.staffName = staffName;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }

    public void setTotalLabel(JLabel totalLabel) {
        this.totalLabel = totalLabel;
    }

    public JLabel getWarrantLabel() {
        return warrantLabel;
    }

    public void setWarrantLabel(JLabel warrantLabel) {
        this.warrantLabel = warrantLabel;
    }

    public JScrollPane getWarrantScrollPane() {
        return warrantScrollPane;
    }

    public void setWarrantScrollPane(JScrollPane warrantScrollPane) {
        this.warrantScrollPane = warrantScrollPane;
    }

    public JTable getWarrantTable() {
        return warrantTable;
    }

    public void setWarrantTable(JTable warrantTable) {
        this.warrantTable = warrantTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLabel1;
    private javax.swing.JLabel backLabel;
    private javax.swing.JLabel carLabel;
    private javax.swing.JScrollPane carScrollPane;
    private javax.swing.JTable carTable;
    private javax.swing.JLabel clientLabel2;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel staffLabel1;
    private javax.swing.JLabel staffName;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel warrantLabel;
    private javax.swing.JScrollPane warrantScrollPane;
    private javax.swing.JTable warrantTable;
    // End of variables declaration//GEN-END:variables
}
