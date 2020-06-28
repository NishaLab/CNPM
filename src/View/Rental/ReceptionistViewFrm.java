/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental;

import DAO.BillDao;
import Model.Staff;
import Model.Contract;
import Model.Bill;
import Controller.Rental.ReceptionistController;
import java.awt.HeadlessException;
import DAO.ContractDao;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import keeptoo.Drag;

/**
 *
 * @author LEGION
 */
public class ReceptionistViewFrm extends javax.swing.JFrame {

    private Staff staff;
    private ArrayList<Contract> contract = new ArrayList<>();
    private ArrayList<Bill> bill = new ArrayList<>();

    /**
     * Creates new form ReceptionistViewFrm
     */
    public ReceptionistViewFrm() {
        initComponents();
        
        Staff staff = new Staff("hung", "hung", "hung", "receptionist");
        staff.setId(1);
        this.staff = staff;
        ReceptionistController a = new ReceptionistController(this);
        a.init();
    }

    public ReceptionistViewFrm(Staff staff) {
        initComponents();
        this.staff = staff;
        ReceptionistController a = new ReceptionistController(this);
        a.init();
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
        contractSide = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        contractText = new javax.swing.JLabel();
        billSide = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        billText = new javax.swing.JLabel();
        logo = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoImage = new javax.swing.JLabel();
        rentalSide = new javax.swing.JPanel();
        icon2 = new javax.swing.JLabel();
        rentText = new javax.swing.JLabel();
        logoutSide = new javax.swing.JPanel();
        icon3 = new javax.swing.JLabel();
        logoutText = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(47, 24, 107));

        contractSide.setBackground(new java.awt.Color(85, 75, 158));
        contractSide.setMinimumSize(new java.awt.Dimension(60, 60));
        contractSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/contract_30px.png"))); // NOI18N
        contractSide.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        contractText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        contractText.setForeground(new java.awt.Color(255, 255, 255));
        contractText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contractText.setText("View Contract");
        contractSide.add(contractText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        billSide.setBackground(new java.awt.Color(85, 75, 158));
        billSide.setMinimumSize(new java.awt.Dimension(60, 60));
        billSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/bill_30px.png"))); // NOI18N
        billSide.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        billText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        billText.setForeground(new java.awt.Color(255, 255, 255));
        billText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        billText.setText("View Bill");
        billSide.add(billText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

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

        rentalSide.setBackground(new java.awt.Color(85, 75, 158));
        rentalSide.setMinimumSize(new java.awt.Dimension(60, 60));
        rentalSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/car_30px.png"))); // NOI18N
        rentalSide.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        rentText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        rentText.setForeground(new java.awt.Color(255, 255, 255));
        rentText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rentText.setText("Car Rental");
        rentalSide.add(rentText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        logoutSide.setBackground(new java.awt.Color(85, 75, 158));
        logoutSide.setMinimumSize(new java.awt.Dimension(60, 60));
        logoutSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/exit_30px.png"))); // NOI18N
        logoutSide.add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        logoutText.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        logoutText.setForeground(new java.awt.Color(255, 255, 255));
        logoutText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutText.setText("Back to Login");
        logoutSide.add(logoutText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contractSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(billSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rentalSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(contractSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(billSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rentalSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        titleLabel.setText("Receptionist/Main Frame");
        titlePanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 360, 60));

        backgroundPanel.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 710, 140));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        backgroundPanel.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 710, 380));

        getContentPane().add(backgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, -1));

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceptionistViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistViewFrm().setVisible(true);
            }
        });
    }

    public ArrayList<Contract> getContract() {
        return contract;
    }

    public void setContract(ArrayList<Contract> contract) {
        this.contract = contract;
    }

    public ArrayList<Bill> getBill() {
        return bill;
    }

    public void setBill(ArrayList<Bill> bill) {
        this.bill = bill;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public JPanel getBackgroundPanel() {
        return backgroundPanel;
    }

    public void setBackgroundPanel(JPanel backgroundPanel) {
        this.backgroundPanel = backgroundPanel;
    }

    public JPanel getBillSide() {
        return billSide;
    }

    public void setBillSide(JPanel billSide) {
        this.billSide = billSide;
    }

    public JLabel getBillText() {
        return billText;
    }

    public void setBillText(JLabel billText) {
        this.billText = billText;
    }

    public JPanel getContractSide() {
        return contractSide;
    }

    public void setContractSide(JPanel contractSide) {
        this.contractSide = contractSide;
    }

    public JLabel getContractText() {
        return contractText;
    }

    public void setContractText(JLabel contractText) {
        this.contractText = contractText;
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

    public JLabel getRentText() {
        return rentText;
    }

    public void setRentText(JLabel rentText) {
        this.rentText = rentText;
    }

    public JPanel getRentalSide() {
        return rentalSide;
    }

    public void setRentalSide(JPanel rentalSide) {
        this.rentalSide = rentalSide;
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
    private javax.swing.JPanel billSide;
    private javax.swing.JLabel billText;
    private javax.swing.JPanel contractSide;
    private javax.swing.JLabel contractText;
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
    private javax.swing.JLabel rentText;
    private javax.swing.JPanel rentalSide;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
