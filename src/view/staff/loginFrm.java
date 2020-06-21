/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.staff;

import Model.Staff;
import DAO.StaffDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemony
 */
public class loginFrm extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form loginFrm
     */
    public loginFrm() {
        super("Login");
        initComponents();
        char passwordchar = passwordpf.getEchoChar();
        passwordpf.setEchoChar((char) 0);
        passwordpf.setText("Password");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        userlbl = new javax.swing.JLabel();
        usernametf = new javax.swing.JTextField();
        passwordpf = new javax.swing.JPasswordField();
        passwordlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginbtn.setText("Login");
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        userlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/user.png"))); // NOI18N
        userlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        usernametf.setBackground(new java.awt.Color(255, 255, 255));
        usernametf.setForeground(new java.awt.Color(51, 51, 51));
        usernametf.setText(" Username");
        usernametf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernametf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernametfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernametfFocusLost(evt);
            }
        });
        usernametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametfActionPerformed(evt);
            }
        });

        passwordpf.setBackground(new java.awt.Color(255, 255, 255));
        passwordpf.setForeground(new java.awt.Color(51, 51, 51));
        passwordpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordpfFocusLost(evt);
            }
        });

        passwordlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/password.png"))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/logoLogin.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordlbl)
                            .addComponent(userlbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordpf)
                            .addComponent(usernametf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernametf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordlbl)
                    .addComponent(passwordpf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginbtn)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametfActionPerformed
    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
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
        } else
            JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
    }//GEN-LAST:event_loginbtnActionPerformed

    private void usernametfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernametfFocusGained
        if (usernametf.getText().equals("Username")) {
            usernametf.setText("");
        }
    }//GEN-LAST:event_usernametfFocusGained

    private void usernametfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernametfFocusLost
        if (usernametf.getText().equals("")) {
            usernametf.setText("Username");
        }
    }//GEN-LAST:event_usernametfFocusLost

    private void passwordpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordpfFocusGained
        
                
    }//GEN-LAST:event_passwordpfFocusGained

    private void passwordpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordpfFocusLost

    }//GEN-LAST:event_passwordpfFocusLost

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
            java.util.logging.Logger.getLogger(loginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JLabel passwordlbl;
    private javax.swing.JPasswordField passwordpf;
    private javax.swing.JLabel userlbl;
    private javax.swing.JTextField usernametf;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
