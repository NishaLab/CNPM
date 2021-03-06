/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.User;

import DAO.CarBrandDao;
import DAO.CarDao;
import Model.CarStat;
import Model.ClientStat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Staff;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import DAO.CarStatDao;
import DAO.CarTypeDao;
import DAO.ClientStatDao;
import Model.BookedCar;
import Model.CarBrand;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Color;
import java.awt.Dimension;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Microsoft Windows
 */
public class ClientStatFrm extends javax.swing.JFrame {

    public static Staff user;

    /**
     * Creates new form ViewStat
     */
    public ClientStatFrm() {
        initComponents();
        jTable1.setFillsViewportHeight(true);
        //this.getContentPane().setBackground(Color.LIGHT_GRAY);

//        UserNameJTF.setText(user.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sdPicker = new com.github.lgooddatepicker.components.DatePicker();
        edPicker = new com.github.lgooddatepicker.components.DatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 51));

        jLabel1.setText("Start Date:");

        jLabel2.setText("End Date:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sdPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(383, 383, 383))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(sdPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(edPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        ClientStatDao csd = new ClientStatDao();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = sdf.parse(sdPicker.getDate().toString());
            endDate = sdf.parse(edPicker.getDate().toString());
        } catch (Exception ex) {
//            e.printStackTrace();
        }

        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(null, "Start Date phải trước End Date!");
            return;
        }
        if (sdPicker.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Hãy nhập Start Date!");
            return;
        }
        if (edPicker.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Hãy nhập End Date");
            return;
        }

        ArrayList<ClientStat> result = new ArrayList<ClientStat>();
        result = csd.getClientStat(startDate, endDate);
        Vector<String> collumNames = new Vector<String>();
        collumNames.add("TT");
        collumNames.add("Client Id");
        collumNames.add("Client Name");
        collumNames.add("CCCD");
        collumNames.add("Phone");
        collumNames.add("Address");
        collumNames.add("Total Day");
        collumNames.add("Total Amount");
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        int tt = 1;
        for (ClientStat cs : result) {
            Vector<String> tmp = new Vector<String>();
            tmp.add("" + tt);
            tmp.add("" + cs.getId());
            tmp.add(cs.getName());
            tmp.add(cs.getCCCD());
            tmp.add(cs.getPhone());
            tmp.add(cs.getAddress());
            tmp.add("" + cs.getTotalContract());
            tmp.add("" + cs.getTotalPayment());
            tt++;
            data.add(tmp);
        }
        DefaultTableModel model = new DefaultTableModel(data, collumNames);
        jTable1.setModel(model);
        jPanel1.revalidate();
        jPanel1.repaint();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                Date startDate = Date.from(sdPicker.getDate().atStartOfDay().toInstant(ZoneOffset.UTC));
                Date endDate = new Date();
                try {
                    startDate = sdf.parse(sdPicker.getDate().toString());
                    endDate = sdf.parse(edPicker.getDate().toString());
                } catch (Exception f) {
                    f.printStackTrace();
                }
               
                ArrayList<ClientStat> clientDetails = csd.getClientStatDetails(startDate, endDate);

                Vector<String> collumNames1 = new Vector<>();
                Vector<Vector<String>> data1 = new Vector<Vector<String>>();
                collumNames1.add("TT");
                collumNames1.add("Car Name");
                collumNames1.add("Receive Date");
                collumNames1.add("Return Date");
                collumNames1.add("Price");
                //collumNames1.add("Penalty Amount");
                collumNames1.add("Total Day");
                collumNames1.add("Total Amount");
                int tt = 1;
                for (ClientStat cs : clientDetails) {
                    Vector<String> tmp = new Vector<>();
                    tmp.add("" + tt);
                    tmp.add(cs.getCName());
                    tmp.add("" + cs.getPrice());
                    tmp.add("" + cs.getPen());
                    tmp.add("" + cs.getTotalDay());
                    tmp.add("" + cs.getTotalPayment());
                    tt++;
                    data1.add(tmp);
                };
            }
        });
    }//GEN-LAST:event_btnViewActionPerformed

    /*
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
            java.util.logging.Logger.getLogger(ClientStatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientStatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientStatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientStatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientStatFrm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView;
    private com.github.lgooddatepicker.components.DatePicker edPicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.github.lgooddatepicker.components.DatePicker sdPicker;
    // End of variables declaration//GEN-END:variables
}
