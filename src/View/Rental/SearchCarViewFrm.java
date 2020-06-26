/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Rental;

import View.Rental.Component.*;
import Model.Car;
import Model.CarClassification;
import Model.CarType;
import Controller.Rental.SearchCarController;
import Model.BookedCar;
import Model.Client;
import Model.Staff;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

/**
 *
 * @author LEGION
 */
public class SearchCarViewFrm extends javax.swing.JFrame {

    private ArrayList<Car> car = new ArrayList<>();
    private ArrayList<Car> chosen = new ArrayList<>();
    private ArrayList<BookedCar> bookedCar = new ArrayList<>();
    private ArrayList<CarType> typeList = new ArrayList<>();
    private ArrayList<CarClassification> classList = new ArrayList<>();
    private Client client;
    private Staff staff;

    public SearchCarViewFrm() {

        initComponents();
        SearchCarController ctrl = new SearchCarController(this);
        ctrl.init();
        staff = new Staff("Hung", "12435", "Nguyen Duc Hung", "Receptionist");
        staff.setId(1);
//        CarCatalogComponent a1 = new CarCatalogComponent();
//        CarCatalogComponent a2 = new CarCatalogComponent();
//        CarCatalogComponent a3 = new CarCatalogComponent();
//        CarCatalogComponent a4 = new CarCatalogComponent();
//        CarCatalogComponent a5 = new CarCatalogComponent();
//        CarCatalogComponent a6 = new CarCatalogComponent();
//        CarCatalogComponent a7 = new CarCatalogComponent();
//        CarCatalogComponent a8 = new CarCatalogComponent();
        mainPanel.setLayout(new BorderLayout());
        carCatalogPanel.setLayout(new GridLayout(2, 4, 10, 10));
        carCatalogPanel.setSize(851, 470);
//        carCatalogPanel.add(a1);
//        carCatalogPanel.add(a2);
//        carCatalogPanel.add(a3);
//        carCatalogPanel.add(a4);
//        carCatalogPanel.add(a5);
//        carCatalogPanel.add(a6);
//        carCatalogPanel.add(a7);
//        carCatalogPanel.add(a8);
//        carCatalogPanel.revalidate();
//        carCatalogPanel.repaint();
        CartComponent b1 = new CartComponent();
//        CartComponent b2 = new CartComponent();
//        CartComponent b3 = new CartComponent();
//        CartComponent b4 = new CartComponent();
//        CartComponent b5 = new CartComponent();
//        CartComponent b6 = new CartComponent();
//        CartComponent b7 = new CartComponent();
//        CartComponent b8 = new CartComponent();
//        CartComponent b9 = new CartComponent();
//        CartComponent b10 = new CartComponent();
//        CartComponent b11 = new CartComponent();
//        CartComponent b12 = new CartComponent();
//        CartComponent b13 = new CartComponent();
//        CartComponent b14 = new CartComponent();
//        CartComponent b15 = new CartComponent();
//        CartComponent b16 = new CartComponent();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.PAGE_AXIS));
        cartPanel.add(b1);
//        cartPanel.add(b2);
//        cartPanel.add(b3);
//        cartPanel.add(b4);
//        cartPanel.add(b5);
//        cartPanel.add(b6);
//        cartPanel.add(b7);
//        cartPanel.add(b8);
//        cartPanel.add(b9);
//        cartPanel.add(b10);
//        cartPanel.add(b11);
//        cartPanel.add(b12);
//        cartPanel.add(b13);
//        cartPanel.add(b14);
//        cartPanel.add(b15);
//        cartPanel.add(b16);
        cartPanel.revalidate();
        cartPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        receivedDateLabel = new javax.swing.JLabel();
        returnDateLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        carType = new javax.swing.JComboBox<>();
        carClass = new javax.swing.JComboBox<>();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        confirmBtt = new javax.swing.JButton();
        searchBtt = new javax.swing.JButton();
        backLabel = new javax.swing.JLabel();
        forwardBtt = new javax.swing.JButton();
        backwardBtt = new javax.swing.JButton();
        pageLabel = new javax.swing.JLabel();
        jumpBtt = new javax.swing.JButton();
        pageField = new javax.swing.JTextField();
        receivedDate = new com.github.lgooddatepicker.components.DateTimePicker();
        returnDate = new com.github.lgooddatepicker.components.DateTimePicker();
        mainPanel = new javax.swing.JPanel();
        carCatalogPanel = new javax.swing.JPanel();
        cartScrollPane = new javax.swing.JScrollPane();
        cartPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLabel.setText("Search Car ");

        receivedDateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        receivedDateLabel.setText("Received Date");

        returnDateLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        returnDateLabel.setText("Return Date");

        typeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        typeLabel.setText("Type");

        classLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        classLabel.setText("Class");

        carType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        carType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        carClass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        carClass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameLabel.setText("Name");

        nameField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        confirmBtt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        confirmBtt.setText("Confirm");

        searchBtt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        searchBtt.setText("Search");

        backLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backLabel.setText("Go Back");

        forwardBtt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        forwardBtt.setText(">");
        forwardBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardBttActionPerformed(evt);
            }
        });

        backwardBtt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backwardBtt.setText("<");

        pageLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageLabel.setText("0/0");

        jumpBtt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jumpBtt.setText("Jump");

        pageField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(receivedDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(returnDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(receivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(backwardBtt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(forwardBtt)
                        .addGap(18, 18, 18)
                        .addComponent(jumpBtt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pageField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(searchBtt)
                        .addGap(59, 59, 59)
                        .addComponent(confirmBtt))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(classLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(carClass, 0, 148, Short.MAX_VALUE)
                                .addComponent(carType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(156, 156, 156)
                .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(receivedDateLabel)
                        .addGap(121, 121, 121)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forwardBtt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jumpBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(titlePanelLayout.createSequentialGroup()
                                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(typeLabel)
                                    .addComponent(carClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(receivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(classLabel)
                                    .addComponent(carType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(returnDateLabel)
                                    .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(titlePanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backwardBtt)
                                    .addComponent(pageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchBtt)
                                    .addComponent(confirmBtt)))))))
        );

        mainPanel.setPreferredSize(new java.awt.Dimension(1178, 490));

        carCatalogPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        carCatalogPanel.setMaximumSize(new java.awt.Dimension(851, 470));
        carCatalogPanel.setMinimumSize(new java.awt.Dimension(851, 470));

        javax.swing.GroupLayout carCatalogPanelLayout = new javax.swing.GroupLayout(carCatalogPanel);
        carCatalogPanel.setLayout(carCatalogPanelLayout);
        carCatalogPanelLayout.setHorizontalGroup(
            carCatalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        carCatalogPanelLayout.setVerticalGroup(
            carCatalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        cartScrollPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartScrollPane.setMinimumSize(new java.awt.Dimension(281, 470));
        cartScrollPane.setPreferredSize(new java.awt.Dimension(281, 470));

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        cartScrollPane.setViewportView(cartPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carCatalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cartScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carCatalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forwardBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardBttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forwardBttActionPerformed

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
            java.util.logging.Logger.getLogger(SearchCarViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCarViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCarViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCarViewFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCarViewFrm().setVisible(true);
            }
        });
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public void setBackLabel(JLabel backLabel) {
        this.backLabel = backLabel;
    }

    public JButton getBackwardBtt() {
        return backwardBtt;
    }

    public void setBackwardBtt(JButton backwardBtt) {
        this.backwardBtt = backwardBtt;
    }

    public JPanel getCarCatalogPanel() {
        return carCatalogPanel;
    }

    public void setCarCatalogPanel(JPanel carCatalogPanel) {
        this.carCatalogPanel = carCatalogPanel;
    }

    public JComboBox<String> getCarClass() {
        return carClass;
    }

    public void setCarClass(JComboBox<String> carClass) {
        this.carClass = carClass;
    }

    public JComboBox<String> getCarType() {
        return carType;
    }

    public void setCarType(JComboBox<String> carType) {
        this.carType = carType;
    }

    public JPanel getCartPanel() {
        return cartPanel;
    }

    public void setCartPanel(JPanel cartPanel) {
        this.cartPanel = cartPanel;
    }

    public JScrollPane getCartScrollPane() {
        return cartScrollPane;
    }

    public void setCartScrollPane(JScrollPane cartScrollPane) {
        this.cartScrollPane = cartScrollPane;
    }

    public JLabel getClassLabel() {
        return classLabel;
    }

    public void setClassLabel(JLabel classLabel) {
        this.classLabel = classLabel;
    }

    public JButton getConfirmBtt() {
        return confirmBtt;
    }

    public void setConfirmBtt(JButton confirmBtt) {
        this.confirmBtt = confirmBtt;
    }

    public JButton getForwardBtt() {
        return forwardBtt;
    }

    public void setForwardBtt(JButton forwardBtt) {
        this.forwardBtt = forwardBtt;
    }

    public JButton getJumpBtt() {
        return jumpBtt;
    }

    public void setJumpBtt(JButton jumpBtt) {
        this.jumpBtt = jumpBtt;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JTextField getPageField() {
        return pageField;
    }

    public void setPageField(JTextField pageField) {
        this.pageField = pageField;
    }

    public JLabel getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(JLabel pageLabel) {
        this.pageLabel = pageLabel;
    }



    public JLabel getReceivedDateLabel() {
        return receivedDateLabel;
    }

    public void setReceivedDateLabel(JLabel receivedDateLabel) {
        this.receivedDateLabel = receivedDateLabel;
    }



    public JLabel getReturnDateLabel() {
        return returnDateLabel;
    }

    public void setReturnDateLabel(JLabel returnDateLabel) {
        this.returnDateLabel = returnDateLabel;
    }

    public JButton getSearchBtt() {
        return searchBtt;
    }

    public void setSearchBtt(JButton searchBtt) {
        this.searchBtt = searchBtt;
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

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(JLabel typeLabel) {
        this.typeLabel = typeLabel;
    }

    public ArrayList<Car> getCar() {
        return car;
    }

    public void setCar(ArrayList<Car> car) {
        this.car = car;
    }

    public ArrayList<CarType> getTypeList() {
        return typeList;
    }

    public void setTypeList(ArrayList<CarType> typeList) {
        this.typeList = typeList;
    }

    public ArrayList<CarClassification> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<CarClassification> classList) {
        this.classList = classList;
    }

    public ArrayList<BookedCar> getBookedCar() {
        return bookedCar;
    }

    public void setBookedCar(ArrayList<BookedCar> bookedCar) {
        this.bookedCar = bookedCar;
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

    public ArrayList<Car> getChosen() {
        return chosen;
    }

    public void setChosen(ArrayList<Car> chosen) {
        this.chosen = chosen;
    }

    public DateTimePicker getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(DateTimePicker receivedDate) {
        this.receivedDate = receivedDate;
    }

    public DateTimePicker getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(DateTimePicker returnDate) {
        this.returnDate = returnDate;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JButton backwardBtt;
    private javax.swing.JPanel carCatalogPanel;
    private javax.swing.JComboBox<String> carClass;
    private javax.swing.JComboBox<String> carType;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JScrollPane cartScrollPane;
    private javax.swing.JLabel classLabel;
    private javax.swing.JButton confirmBtt;
    private javax.swing.JButton forwardBtt;
    private javax.swing.JButton jumpBtt;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField pageField;
    private javax.swing.JLabel pageLabel;
    private com.github.lgooddatepicker.components.DateTimePicker receivedDate;
    private javax.swing.JLabel receivedDateLabel;
    private com.github.lgooddatepicker.components.DateTimePicker returnDate;
    private javax.swing.JLabel returnDateLabel;
    private javax.swing.JButton searchBtt;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
