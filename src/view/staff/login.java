/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.staff;

import Model.Staff;
import DAO.StaffDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemony
 */
public class login extends javax.swing.JFrame {

    public login() {
        super("Login");
        initComponents();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        usernametf = new javax.swing.JTextField();
        passwordpf = new javax.swing.JPasswordField();
        loginbtn = new javax.swing.JButton();
        userlbl = new javax.swing.JLabel();
        passwordlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernametf.setBackground(new java.awt.Color(255, 255, 255));
        usernametf.setForeground(new java.awt.Color(51, 51, 51));
        usernametf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernametf.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernametfFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernametfFocusLost(evt);
            }
        });

        passwordpf.setBackground(new java.awt.Color(255, 255, 255));
        passwordpf.setForeground(new java.awt.Color(51, 51, 51));
        passwordpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        loginbtn.setText("Login");
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            loginbtnActionPerformed(evt);
        });

        userlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/user.png"))); // NOI18N
        userlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        passwordlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/password.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordlbl)
                                        .addComponent(userlbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordpf)
                                        .addComponent(usernametf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(54, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(usernametf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordlbl)
                                        .addComponent(passwordpf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(loginbtn)
                                .addGap(17, 17, 17))
        );

        pack();
    }

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {
        Staff s = new Staff();
        s.setName(usernametf.getText());
        s.setPassword(passwordpf.getText());

        StaffDAO sd = new StaffDAO();
        if (sd.checkLogin(s)) {
            if (s.getPositon().equalsIgnoreCase("manager")) {
                (new managerHomeFrm(s)).setVisible(true);
                this.dispose();
            } else if (s.getPositon().equalsIgnoreCase("cashier")) {
                (new cashierHomeFrm(s)).setVisible(true);
                this.dispose();
            } else if (s.getPositon().equalsIgnoreCase("receptionist")) {
                (new receptionistHomeFrm(s)).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Function of the role" + s.getPositon() + "is under construction!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
        }
    }

    private void usernametfFocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void usernametfFocusLost(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel passwordlbl;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField passwordpf;
    private javax.swing.JLabel userlbl;
    private javax.swing.JTextField usernametf;
    // End of variables declaration                   
}
