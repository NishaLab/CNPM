/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;

import DAO.CarBrandDao;
import DAO.CarDao;
import Model.CarStat;
import DAO.CarStatDao;
import Model.CarBrandStat;
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
 * @author Vu Minh Duc
 */
public class ViewStat extends javax.swing.JFrame {

    public static Staff user;

    /**
     * Creates new form ViewStat
     */
    public ViewStat(Staff user) {
        initComponents();
        jTable1.setFillsViewportHeight(true);
        this.user = user;
        UserNameJTF.setText(user.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserNameJTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sdPicker = new com.github.lgooddatepicker.components.DatePicker();
        edPicker = new com.github.lgooddatepicker.components.DatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        viewBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Start Date");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));

        jLabel2.setText("End Date");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 102));

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vu Minh Duc\\Pictures\\CNPM\\user.png")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vu Minh Duc\\Pictures\\CNPM\\icon team.png")); // NOI18N
        jLabel4.setBackground(new java.awt.Color(153, 153, 153));

        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(611, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(163, 163, 163))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(edPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sdPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(61, 61, 61)
                            .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(443, 443, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                                    .addComponent(UserNameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap()))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 612, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UserNameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(sdPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(edPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(viewBtn)))))
                    .addGap(51, 51, 51)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        CarStatDao csd = new CarStatDao();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = Date.from(sdPicker.getDate().atStartOfDay().toInstant(ZoneOffset.UTC));
            endDate = Date.from(edPicker.getDate().atStartOfDay().toInstant(ZoneOffset.UTC));
        } catch (NullPointerException e) {

        }
        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc ! ");
            return;
        }
        if (sdPicker.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Mời nhập ngày bắt đầu !");
            return;
        }
        if (edPicker.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Mời nhập ngày kết thúc !");
            return;
        }

        ArrayList<CarBrandStat> result = new ArrayList<CarBrandStat>();
        result = csd.getCarBrandStat(startDate, endDate);
        Vector<String> collumNames = new Vector<String>();
        collumNames.add("STT");
        collumNames.add("Id");
        collumNames.add("Name");
        collumNames.add("RentTime");
        collumNames.add("Days");        
        collumNames.add("Income");
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        int stt = 1;
        for (CarBrandStat cbs : result) {
            Vector<String> tmp = new Vector<String>();
            tmp.add("" + stt);
            tmp.add("" + cbs.getId());
            tmp.add(cbs.getName());
            tmp.add(""+cbs.getRentTime());
            tmp.add("" + cbs.getTotalDay());
            tmp.add("" + cbs.getIncome());           
            stt++;
            data.add(tmp);
        }
        DefaultTableModel model = new DefaultTableModel(data, collumNames);
        jTable1 = new JTable();
        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);
        jPanel1.revalidate();
        jPanel1.repaint();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int brandid = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                Date startDate = Date.from(sdPicker.getDate().atStartOfDay().toInstant(ZoneOffset.UTC));
                Date endDate = Date.from(edPicker.getDate().atStartOfDay().toInstant(ZoneOffset.UTC));
                try {
                    startDate = sdf.parse(sdPicker.getDate().toString());
                    endDate = sdf.parse(edPicker.getDate().toString());
                } catch (Exception f) {
                    f.printStackTrace();
                }

//                if(startDate.after(endDate)==false){
//                    JOptionPane.showMessageDialog(null,"Nhap sai ngay");
//                    return;
//                }
                ArrayList<CarStat> brandDetails = csd.getDetailsBrandStat(startDate, endDate, brandid);

                collumNames.clear();
                data.clear();
                collumNames.add("STT");
                collumNames.add("Id");
                collumNames.add("CarName");
                collumNames.add("RegPlate");
                collumNames.add("RentTime");
                collumNames.add("Days");
                collumNames.add("Income");
                int stt = 1;
                for (CarStat cs : brandDetails) {
                    Vector<String> tmp = new Vector<>();
                    tmp.add("" + stt);
                    tmp.add("" + cs.getId());
                    tmp.add(cs.getName());
                    tmp.add(cs.getRegPlate());
                    tmp.add(""+cs.getRentTime());
                    tmp.add("" + cs.getTotalDay());
                    tmp.add("" + cs.getIncome());
                    stt++;
                    data.add(tmp);
                }
                DefaultTableModel model1 = new DefaultTableModel(data, collumNames);
                jTable1 = new JTable();
                jTable1.setModel(model1);
                jScrollPane1.setViewportView(jTable1);
                jPanel1.revalidate();
                jPanel1.repaint();

                jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int carid = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                        Date startDate = new Date();
                        Date endDate = new Date();
                        try {
                            startDate = sdf.parse(sdPicker.getDate().toString());
                            endDate = sdf.parse(edPicker.getDate().toString());
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                        ArrayList<CarStat> carDetails = csd.getDetailsCarStat(startDate, endDate, carid);
                        collumNames.clear();
                        data.clear();
                        collumNames.add("STT");
                        collumNames.add("Id");
                        collumNames.add("Car_Name");
                        collumNames.add("Reg_Plate");
                        collumNames.add("Brand");
                        collumNames.add("Type");
                        collumNames.add("Client_Name");
                        collumNames.add("Days");
                        collumNames.add("Income");
                        collumNames.add("PenAmount");
                        int stt = 1;
                        for (CarStat cs : carDetails) {
                            Vector<String> tmp = new Vector<>();
                            tmp.add("" + stt);
                            tmp.add("" + cs.getId());
                            tmp.add(cs.getName());
                            tmp.add(cs.getRegPlate());
                            tmp.add(cs.getBrand().getName());
                            tmp.add(cs.getType().getName());
                            tmp.add(cs.getClientName());
                            tmp.add("" + cs.getTotalDay());
                            tmp.add("" + cs.getIncome());
                            tmp.add(""+cs.getPenAmount());
                            stt++;
                            data.add(tmp);
                        }
                        DefaultTableModel model2 = new DefaultTableModel(data, collumNames);
                        jTable1 = new JTable();
                        jTable1.setModel(model2);
                        jTable1.setDefaultEditor(Object.class, null);
                        jTable1.setRowSelectionAllowed(false);
                        jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
                        jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
                        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
                        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
                        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
                        jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);

                        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

                        jScrollPane1.setViewportView(jTable1);
                        jPanel1.revalidate();
                        jPanel1.repaint();
                    }

                });
            }
        });
    }//GEN-LAST:event_viewBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStat(user).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UserNameJTF;
    private com.github.lgooddatepicker.components.DatePicker edPicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.github.lgooddatepicker.components.DatePicker sdPicker;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
