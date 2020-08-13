/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental;

import Model.BookedCar;
import Model.Client;
import Model.Contract;
import Model.ContractWarrant;
import Model.Staff;
import java.awt.Font;
import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import keeptoo.KGradientPanel;

/**
 *
 * @author LEGION
 */
public class ContractViewAuxFrm extends javax.swing.JFrame {

    /**
     * Creates new form ContractViewAuxFrm
     */
    private ArrayList<BookedCar> bc = new ArrayList<>();
    private ArrayList<ContractWarrant> cw = new ArrayList<>();
    private Client client;
    private Staff staff;
    private Date bookingDate = new Date();

    public ContractViewAuxFrm() throws HeadlessException {
    }

    public ContractViewAuxFrm(Contract contract) {
        initComponents();
        this.bc = contract.getCar();
        this.cw = contract.getConWarrant();
        this.client = contract.getClient();
        this.staff = contract.getStaff();
        DecimalFormat formatter = new DecimalFormat("#,###");
        DefaultTableModel ctb = (DefaultTableModel) this.getCarTable().getModel();
        DefaultTableModel wtb = (DefaultTableModel) this.getWarrantTable().getModel();
        ctb.setRowCount(0);
        wtb.setRowCount(0);
        ArrayList<BookedCar> bc = this.getBc();
        ArrayList<ContractWarrant> cw = this.getCw();
        Client client = this.getClient();
        Staff staff = this.getStaff();
        JTextField clientName = this.getClientName();
        clientName.setText(client.getName());
        clientName.setEditable(false);
        JTextField staffName = this.getStaffName();
        staffName.setText(staff.getName());
        staffName.setEditable(false);
        long deposit = 1000000 * bc.size();
        this.getDeposit().setText(formatter.format(deposit));
        this.getDeposit().setEditable(false);
        long total = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (BookedCar bookedCar : bc) {
            long amount = 0;
            amount += bookedCar.getTotalPrice();
            total += amount;
            Object[] tmp;
            tmp = new Object[]{bookedCar.getCar().getId(), bookedCar.getCar().getName(), sdf.format(bookedCar.getReceivedDate()),
                sdf.format(bookedCar.getReturnDate()), formatter.format(amount), bookedCar.getCar().getRegPlate()};
            ctb.addRow(tmp);
        }
        for (ContractWarrant warrant : cw) {
            Object[] tmp;
            tmp = new Object[]{sdf.format(warrant.getCheckIn()), sdf.format(warrant.getCheckOut()), warrant.getWarrant().getType(),
                warrant.getWarrant().getValue(), warrant.getWarrant().getDesc()};
            wtb.addRow(tmp);
        }
        total += deposit;
        this.getTotal().setText(formatter.format(total));
        this.getTotal().setEditable(false);
        Date date = new Date();
        this.getDate().setText(date.toString());
        this.getDate().setEditable(false);
        this.getCarTable().getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        this.getWarrantTable().getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new javax.swing.JPanel();
        sidePanel1 = new javax.swing.JPanel();
        logo1 = new javax.swing.JPanel();
        logoLabel1 = new javax.swing.JLabel();
        logoImage1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        bgPanel = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        staffName = new javax.swing.JTextField();
        clientName = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        deposit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        carScrollPane = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        warrantScrollPane = new javax.swing.JScrollPane();
        warrantTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        sidePanel1.setBackground(new java.awt.Color(47, 24, 107));

        logo1.setBackground(new java.awt.Color(47, 24, 107));
        logo1.setMinimumSize(new java.awt.Dimension(270, 170));
        logo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        logoLabel1.setForeground(new java.awt.Color(255, 255, 255));
        logoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel1.setText("ALT F4 Rental");
        logo1.add(logoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, 60));

        logoImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Rental/Icon/f1_car_60px.png"))); // NOI18N
        logoImage1.setMaximumSize(new java.awt.Dimension(50, 50));
        logoImage1.setMinimumSize(new java.awt.Dimension(50, 50));
        logo1.add(logoImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout sidePanel1Layout = new javax.swing.GroupLayout(sidePanel1);
        sidePanel1.setLayout(sidePanel1Layout);
        sidePanel1Layout.setHorizontalGroup(
            sidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanel1Layout.setVerticalGroup(
            sidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanel1Layout.createSequentialGroup()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        staffName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffName.setForeground(new java.awt.Color(102, 102, 102));
        staffName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        clientName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientName.setForeground(new java.awt.Color(102, 102, 102));
        clientName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date.setForeground(new java.awt.Color(102, 102, 102));
        date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(12, 91, 160));
        jLabel3.setText("Contract");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(12, 91, 160));
        jLabel5.setText("Staff name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(12, 91, 160));
        jLabel6.setText("Client name");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(12, 91, 160));
        jLabel7.setText("Booking Date");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(12, 91, 160));
        jLabel8.setText("Deposit Fee");

        deposit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deposit.setForeground(new java.awt.Color(102, 102, 102));
        deposit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(12, 91, 160));
        jLabel9.setText("Total");

        total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(102, 102, 102));
        total.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        carScrollPane.setBorder(null);

        carTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Received Date", "Return Date", "Total Price", "Plate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        carTable.setShowGrid(true);
        carTable.setShowHorizontalLines(false);
        carScrollPane.setViewportView(carTable);
        if (carTable.getColumnModel().getColumnCount() > 0) {
            carTable.getColumnModel().getColumn(0).setMinWidth(30);
            carTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            carTable.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(12, 91, 160));
        jLabel10.setText("Car");

        warrantTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        warrantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Check In", "Check Out", "Type", "Value", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        warrantScrollPane.setViewportView(warrantTable);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(12, 91, 160));
        jLabel11.setText("Warrant");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(deposit, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(date)
                    .addComponent(clientName)
                    .addComponent(staffName)
                    .addComponent(total))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addComponent(warrantScrollPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(carScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(warrantScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1144, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addComponent(sidePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1424, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backgroundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(backgroundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(ContractViewAuxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContractViewAuxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContractViewAuxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContractViewAuxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContractViewAuxFrm().setVisible(true);
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public JPanel getBackgroundPanel1() {
        return backgroundPanel1;
    }

    public void setBackgroundPanel1(JPanel backgroundPanel1) {
        this.backgroundPanel1 = backgroundPanel1;
    }

    public KGradientPanel getBgPanel() {
        return bgPanel;
    }

    public void setBgPanel(KGradientPanel bgPanel) {
        this.bgPanel = bgPanel;
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

    public JTextField getClientName() {
        return clientName;
    }

    public void setClientName(JTextField clientName) {
        this.clientName = clientName;
    }

    public JTextField getDate() {
        return date;
    }

    public void setDate(JTextField date) {
        this.date = date;
    }

    public JTextField getDeposit() {
        return deposit;
    }

    public void setDeposit(JTextField deposit) {
        this.deposit = deposit;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getLogo1() {
        return logo1;
    }

    public void setLogo1(JPanel logo1) {
        this.logo1 = logo1;
    }

    public JLabel getLogoImage1() {
        return logoImage1;
    }

    public void setLogoImage1(JLabel logoImage1) {
        this.logoImage1 = logoImage1;
    }

    public JLabel getLogoLabel1() {
        return logoLabel1;
    }

    public void setLogoLabel1(JLabel logoLabel1) {
        this.logoLabel1 = logoLabel1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getSidePanel1() {
        return sidePanel1;
    }

    public void setSidePanel1(JPanel sidePanel1) {
        this.sidePanel1 = sidePanel1;
    }

    public JTextField getStaffName() {
        return staffName;
    }

    public void setStaffName(JTextField staffName) {
        this.staffName = staffName;
    }

    public JTextField getTotal() {
        return total;
    }

    public void setTotal(JTextField total) {
        this.total = total;
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
    private javax.swing.JPanel backgroundPanel1;
    private keeptoo.KGradientPanel bgPanel;
    private javax.swing.JScrollPane carScrollPane;
    private javax.swing.JTable carTable;
    private javax.swing.JTextField clientName;
    private javax.swing.JTextField date;
    private javax.swing.JTextField deposit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logo1;
    private javax.swing.JLabel logoImage1;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidePanel1;
    private javax.swing.JTextField staffName;
    private javax.swing.JTextField total;
    private javax.swing.JScrollPane warrantScrollPane;
    private javax.swing.JTable warrantTable;
    // End of variables declaration//GEN-END:variables
}
