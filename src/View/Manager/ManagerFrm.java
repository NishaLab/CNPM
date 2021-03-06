/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;

import Model.Staff;
import Controller.Manager.ManagerFrameController;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LEGION
 */
public class ManagerFrm extends javax.swing.JFrame {

    private Staff staff;

    /**
     * Creates new form ManagerFrame
     */
    public ManagerFrm() {
        initComponents();
        ManagerFrameController mfc = new ManagerFrameController(this);
        mfc.init();
    }

    public ManagerFrm(Staff staff) {
        initComponents();
        this.staff = staff;
        ManagerFrameController mfc = new ManagerFrameController(this);
        mfc.init();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        carStatSide = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        carStatText = new javax.swing.JLabel();
        clientStatSide = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        clientStatText = new javax.swing.JLabel();
        logo = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoImage = new javax.swing.JLabel();
        carSide = new javax.swing.JPanel();
        icon2 = new javax.swing.JLabel();
        carText = new javax.swing.JLabel();
        logoutSide = new javax.swing.JPanel();
        icon3 = new javax.swing.JLabel();
        logoutText = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(47, 24, 107));

        carStatSide.setBackground(new java.awt.Color(85, 75, 158));
        carStatSide.setMinimumSize(new java.awt.Dimension(60, 60));
        carStatSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/contract_30px.png"))); // NOI18N
        carStatSide.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        carStatText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        carStatText.setForeground(new java.awt.Color(255, 255, 255));
        carStatText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carStatText.setText("View Car Stat");
        carStatSide.add(carStatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        clientStatSide.setBackground(new java.awt.Color(85, 75, 158));
        clientStatSide.setMinimumSize(new java.awt.Dimension(60, 60));
        clientStatSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/bill_30px.png"))); // NOI18N
        clientStatSide.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        clientStatText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        clientStatText.setForeground(new java.awt.Color(255, 255, 255));
        clientStatText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientStatText.setText("View Client Stat");
        clientStatSide.add(clientStatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        logo.setBackground(new java.awt.Color(47, 24, 107));
        logo.setMinimumSize(new java.awt.Dimension(270, 170));
        logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("ALT F4 Rental");
        logo.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, 60));

        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/f1_car_60px.png"))); // NOI18N
        logoImage.setMaximumSize(new java.awt.Dimension(50, 50));
        logoImage.setMinimumSize(new java.awt.Dimension(50, 50));
        logo.add(logoImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        carSide.setBackground(new java.awt.Color(85, 75, 158));
        carSide.setMinimumSize(new java.awt.Dimension(60, 60));
        carSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/car_30px.png"))); // NOI18N
        carSide.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        carText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        carText.setForeground(new java.awt.Color(255, 255, 255));
        carText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carText.setText("Car");
        carSide.add(carText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        logoutSide.setBackground(new java.awt.Color(85, 75, 158));
        logoutSide.setMinimumSize(new java.awt.Dimension(60, 60));
        logoutSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/exit_30px.png"))); // NOI18N
        logoutSide.add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        logoutText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        logoutText.setForeground(new java.awt.Color(255, 255, 255));
        logoutText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutText.setText("Back to Login");
        logoutSide.add(logoutText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carStatSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clientStatSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(carSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(carStatSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(clientStatSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(carSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(logoutSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        backgroundPanel.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 580));

        titlePanel.setBackground(new java.awt.Color(93, 47, 208));
        titlePanel.setPreferredSize(new java.awt.Dimension(710, 100));
        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Manager/Main Frame");
        titlePanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 360, 60));

        backgroundPanel.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 710, 140));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        backgroundPanel.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 710, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerFrm().setVisible(true);
            }
        });
    }

    public JPanel getBackgroundPanel() {
        return backgroundPanel;
    }

    public void setBackgroundPanel(JPanel backgroundPanel) {
        this.backgroundPanel = backgroundPanel;
    }

    public JPanel getCarSide() {
        return carSide;
    }

    public void setCarSide(JPanel carSide) {
        this.carSide = carSide;
    }

    public JPanel getCarStatSide() {
        return carStatSide;
    }

    public void setCarStatSide(JPanel carStatSide) {
        this.carStatSide = carStatSide;
    }

    public JLabel getCarStatText() {
        return carStatText;
    }

    public void setCarStatText(JLabel carStatText) {
        this.carStatText = carStatText;
    }

    public JLabel getCarText() {
        return carText;
    }

    public void setCarText(JLabel carText) {
        this.carText = carText;
    }

    public JPanel getClientStatSide() {
        return clientStatSide;
    }

    public void setClientStatSide(JPanel clientStatSide) {
        this.clientStatSide = clientStatSide;
    }

    public JLabel getClientStatText() {
        return clientStatText;
    }

    public void setClientStatText(JLabel clientStatText) {
        this.clientStatText = clientStatText;
    }

    public JLabel getIcon() {
        return icon;
    }

    public void setIcon(JLabel icon) {
        this.icon = icon;
    }

    public JLabel getIcon1() {
        return icon1;
    }

    public void setIcon1(JLabel icon1) {
        this.icon1 = icon1;
    }

    public JLabel getIcon2() {
        return icon2;
    }

    public void setIcon2(JLabel icon2) {
        this.icon2 = icon2;
    }

    public JLabel getIcon3() {
        return icon3;
    }

    public void setIcon3(JLabel icon3) {
        this.icon3 = icon3;
    }

    public JPanel getLogo() {
        return logo;
    }

    public void setLogo(JPanel logo) {
        this.logo = logo;
    }

    public JLabel getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(JLabel logoImage) {
        this.logoImage = logoImage;
    }

    public JLabel getLogoLabel() {
        return logoLabel;
    }

    public void setLogoLabel(JLabel logoLabel) {
        this.logoLabel = logoLabel;
    }

    public JPanel getLogoutSide() {
        return logoutSide;
    }

    public void setLogoutSide(JPanel logoutSide) {
        this.logoutSide = logoutSide;
    }

    public JLabel getLogoutText() {
        return logoutText;
    }

    public void setLogoutText(JLabel logoutText) {
        this.logoutText = logoutText;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(JPanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel carSide;
    private javax.swing.JPanel carStatSide;
    private javax.swing.JLabel carStatText;
    private javax.swing.JLabel carText;
    private javax.swing.JPanel clientStatSide;
    private javax.swing.JLabel clientStatText;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel logoImage;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel logoutSide;
    private javax.swing.JLabel logoutText;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
