/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental;

import Model.Client;
import Controller.Rental.AddWarrantController;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author LEGION
 */
public class AddWarrantViewFrm extends javax.swing.JFrame {

    private Client client = new Client();
    
    /**
     * Creates new form AddWarrantViewFrm
     */
    public AddWarrantViewFrm() {
        initComponents();
    }

    public AddWarrantViewFrm(Client client) {
        initComponents();
        this.client = client;
        warrantTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        AddWarrantController a = new AddWarrantController(this);
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
        addLabel = new javax.swing.JLabel();
        billSide = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        confrimLabel = new javax.swing.JLabel();
        logo = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoImage = new javax.swing.JLabel();
        logoutSide = new javax.swing.JPanel();
        icon3 = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        warrantTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(47, 24, 107));

        contractSide.setBackground(new java.awt.Color(85, 75, 158));
        contractSide.setMinimumSize(new java.awt.Dimension(60, 60));
        contractSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/client_management_30px.png"))); // NOI18N
        contractSide.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        addLabel.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addLabel.setText("Add Warrant");
        contractSide.add(addLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        billSide.setBackground(new java.awt.Color(85, 75, 158));
        billSide.setMinimumSize(new java.awt.Dimension(60, 60));
        billSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/checked_30px.png"))); // NOI18N
        billSide.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        confrimLabel.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        confrimLabel.setForeground(new java.awt.Color(255, 255, 255));
        confrimLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confrimLabel.setText("Confirm");
        billSide.add(confrimLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

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

        logoutSide.setBackground(new java.awt.Color(85, 75, 158));
        logoutSide.setMinimumSize(new java.awt.Dimension(60, 60));
        logoutSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/exit_30px.png"))); // NOI18N
        logoutSide.add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        backLabel.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        backLabel.setForeground(new java.awt.Color(255, 255, 255));
        backLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLabel.setText("Back to contract");
        logoutSide.add(backLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contractSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(billSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(contractSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(billSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(logoutSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        backgroundPanel.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 580));

        titlePanel.setBackground(new java.awt.Color(93, 47, 208));
        titlePanel.setPreferredSize(new java.awt.Dimension(710, 100));
        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Receptionist/Add Warrant");
        titlePanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 360, 60));

        backgroundPanel.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 710, 140));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        warrantTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        warrantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Value", "Desc"
            }
        ));
        jScrollPane1.setViewportView(warrantTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddWarrantViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWarrantViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWarrantViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWarrantViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWarrantViewFrm().setVisible(true);
            }
        });
    }

    public JLabel getAddLabel() {
        return addLabel;
    }

    public void setAddLabel(JLabel addLabel) {
        this.addLabel = addLabel;
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

    public JLabel getConfrimLabel() {
        return confrimLabel;
    }

    public void setConfrimLabel(JLabel confrimLabel) {
        this.confrimLabel = confrimLabel;
    }

    public JPanel getContractSide() {
        return contractSide;
    }

    public void setContractSide(JPanel contractSide) {
        this.contractSide = contractSide;
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

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }


    public JLabel getBackLabel() {
        return backLabel;
    }

    public void setBackLabel(JLabel backLabel) {
        this.backLabel = backLabel;
    }



    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JTable getWarrantTable() {
        return warrantTable;
    }

    public void setWarrantTable(JTable warrantTable) {
        this.warrantTable = warrantTable;
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLabel;
    private javax.swing.JLabel backLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel billSide;
    private javax.swing.JLabel confrimLabel;
    private javax.swing.JPanel contractSide;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel logoImage;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel logoutSide;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTable warrantTable;
    // End of variables declaration//GEN-END:variables
}
