/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.login;

import Model.Staff;
import DAO.StaffDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.Rental.ReceptionistViewFrm;
import View.Manager.ManagerFrm;

/**
 *
 * @author Lemony
 */
public class Login extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form loginFrm
     */
    public Login() {
        super("Login");
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        logoImage = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        loginbtn = new keeptoo.KButton();
        userLabel = new javax.swing.JLabel();
        usernametf = new javax.swing.JTextField();
        passwordlbl = new javax.swing.JLabel();
        passwordpf = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/f1_car_60px.png"))); // NOI18N
        logoImage.setMaximumSize(new java.awt.Dimension(50, 50));
        logoImage.setMinimumSize(new java.awt.Dimension(50, 50));
        bgPanel.add(logoImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, 100));

        logoLabel.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("ALT F4 Rental");
        bgPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 310, 100));

        loginbtn.setBorder(null);
        loginbtn.setText("Log In");
        loginbtn.setkBorderRadius(50);
        loginbtn.setkEndColor(new java.awt.Color(255, 0, 255));
        loginbtn.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        loginbtn.setkHoverForeGround(new java.awt.Color(0, 0, 204));
        loginbtn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        loginbtn.setkStartColor(new java.awt.Color(12, 91, 160));
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        bgPanel.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 227, -1));

        userLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(12, 91, 160));
        userLabel.setText("Name");
        bgPanel.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        usernametf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernametf.setForeground(new java.awt.Color(102, 102, 102));
        usernametf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        bgPanel.add(usernametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 295, -1));

        passwordlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordlbl.setForeground(new java.awt.Color(12, 91, 160));
        passwordlbl.setText("Password");
        bgPanel.add(passwordlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        passwordpf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        bgPanel.add(passwordpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 295, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/login.png"))); // NOI18N
        bgPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        // TODO add your handling code here:
        Staff s = new Staff();
        s.setUserName(usernametf.getText());
        s.setPassword(passwordpf.getText());

        StaffDao sd = new StaffDao();
        if (sd.checkLogin(s)) {
            if (s.getPositon().equalsIgnoreCase("cashier")) {
                (new CashierHomeFrm(s)).setVisible(true);
                this.dispose();
            } else if (s.getPositon().equalsIgnoreCase("manager")) {
                (new ManagerFrm(s)).setVisible(true);
                this.dispose();
            } else if (s.getPositon().equalsIgnoreCase("receptionist")) {
                (new ReceptionistViewFrm(s)).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Function of the role" + s.getPositon() + "is under construction!");
            }
        } else
            JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
    }//GEN-LAST:event_loginbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel jLabel1;
    private keeptoo.KButton loginbtn;
    private javax.swing.JLabel logoImage;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel passwordlbl;
    private javax.swing.JPasswordField passwordpf;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField usernametf;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
