/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.Car;
import Model.CarType;
import Model.CarClassification;
import View.Rental.SearchCarViewFrm;
import View.Rental.Component.*;
import View.Rental.SearchClientViewFrm;
import View.Rental.ContractViewFrm;
import DAO.CarDao;
import DAO.CarTypeDao;
import DAO.CarClassificationDao;
import Model.BookedCar;
import Model.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author LEGION
 */
public class SearchCarController {

    private SearchCarViewFrm frame;

    public SearchCarController(SearchCarViewFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setUp();
        setSearchAction();
        setBackwardAction();
        setForwardAction();
        setJumpAction();
        setConfirmAction();
    }

    public void setUp() {
        ArrayList<CarType> carType = new ArrayList<>();
        ArrayList<CarClassification> carClass = new ArrayList<>();
        CarTypeDao typeDao = new CarTypeDao();
        CarClassificationDao classDao = new CarClassificationDao();
        JComboBox<String> typeCB = this.frame.getCarType();
        carType = typeDao.getAllCarType();
        for (CarType carType1 : carType) {
            typeCB.addItem(carType1.getName());
        }
        carClass = classDao.getAllCarClass();
        JComboBox<String> classCB = this.frame.getCarClass();
        for (CarClassification carClas : carClass) {
            classCB.addItem(carClas.getName());
        }
        this.frame.setTypeList(carType);
        this.frame.setClassList(carClass);
    }

    public void setSearchAction() {
        JButton search = this.frame.getSearchBtt();
        ArrayList<CarType> ct = this.frame.getTypeList();
        ArrayList<CarClassification> cc = this.frame.getClassList();
        JLabel page = this.frame.getPageLabel();
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime received = frame.getReceivedDate().getDateTimeStrict();
                LocalDateTime returnn = frame.getReturnDate().getDateTimeStrict();
                if (received == null || returnn == null) {
                    JOptionPane.showMessageDialog(null, "Please Select Received Date and Return Date", "Try Again", 1);
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date receivedDate = Date.from(received.toInstant(ZoneOffset.UTC));
                Date returnDate = Date.from(returnn.toInstant(ZoneOffset.UTC));
                java.sql.Timestamp sqlreceived = new java.sql.Timestamp(receivedDate.getTime());
                java.sql.Timestamp sqlreturn = new java.sql.Timestamp(returnDate.getTime());

                if (receivedDate.compareTo(returnDate) != -1) {
                    JOptionPane.showMessageDialog(null, "Return date must be greater than Received date", "Try Again", 1);
                    return;
                }
                String name = frame.getNameField().getText().trim();
                String carType = frame.getCarType().getSelectedItem().toString();
                String carClass = frame.getCarClass().getSelectedItem().toString();
                int typeId = 0;
                int classId = 0;
                for (CarType carType1 : ct) {
                    if (carType1.getName().equalsIgnoreCase(carType)) {
                        typeId = carType1.getId();
                        break;
                    }
                }
                for (CarClassification carClassification : cc) {
                    if (carClassification.getName().equalsIgnoreCase(carClass)) {
                        classId = carClassification.getId();
                        break;
                    }
                }
                CarDao dao = new CarDao();
                try {
                    frame.setCar(dao.searchCar(receivedDate, returnDate, name, typeId, classId));
                    ArrayList<Car> car = frame.getCar();
                    page.setText("1" + "/" + (int) Math.ceil((double) car.size() / 6));
                    frame.getCarCatalogPanel().removeAll();
                    for (int i = 0, j = 0; i < 6 && j < car.size(); i++, j++) {
                        frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i), frame));
                    }
                    frame.getCarCatalogPanel().revalidate();
                    frame.getCarCatalogPanel().repaint();
                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        });
    }

    public void setForwardAction() {
        JButton forward = this.frame.getForwardBtt();
        JLabel pageLabel = this.frame.getPageLabel();
        forward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> car = frame.getCar();
                String[] tmp = pageLabel.getText().split("/");
                int page = Integer.parseInt(tmp[0]) + 1;
                int totalpage = Integer.parseInt(tmp[1]);
                if (page > totalpage) {
                    return;
                }
                pageLabel.setText(page + "/" + tmp[1]);
                int offset = (page - 1) * 6;
                frame.getCarCatalogPanel().removeAll();
                for (int i = offset; i < offset + 6 && i < car.size(); i++) {
                    frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i), frame));
                }
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public void setBackwardAction() {
        JButton backward = this.frame.getBackwardBtt();
        JLabel pageLabel = this.frame.getPageLabel();
        backward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> car = frame.getCar();
                String[] tmp = pageLabel.getText().split("/");
                int page = Integer.parseInt(tmp[0]) - 1;
                int totalpage = Integer.parseInt(tmp[1]);
                if (page < 1) {
                    return;
                }
                pageLabel.setText(page + "/" + tmp[1]);
                int offset = (page - 1) * 6;
                frame.getCarCatalogPanel().removeAll();
                for (int i = offset; i < offset + 6 && i < car.size(); i++) {
                    frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i), frame));
                }
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public void setJumpAction() {
        JButton jump = this.frame.getJumpBtt();
        JTextField page = this.frame.getPageField();
        JLabel pageLabel = this.frame.getPageLabel();
        jump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> car = frame.getCar();
                int pageNum = 0;
                try {
                    pageNum = Integer.parseInt(page.getText());
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "Wrong Page Number", "Try Again", 1);
                    return;
                }
                String[] tmp = pageLabel.getText().split("/");
                int totalpage = Integer.parseInt(tmp[1]);
                if (pageNum < 1) {
                    pageNum = 0;
                } else if (pageNum > totalpage) {
                    pageNum = totalpage;
                }
                pageLabel.setText(pageNum + "/" + totalpage);
                int offset = (pageNum - 1) * 6;
                frame.getCarCatalogPanel().removeAll();
                for (int i = offset; i < offset + 6 && i < car.size(); i++) {
                    frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i), frame));
                }
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public void setConfirmAction() {
        JButton confirmBtt = this.frame.getConfirmBtt();
        confirmBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchClientViewFrm scvf = new SearchClientViewFrm();
                JButton confirm = scvf.getConfirmButton();
                JTable ctb = scvf.getjTable1();
                Client client = new Client();
                frame.setVisible(false);
                scvf.setVisible(true);
                confirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int row = ctb.getSelectedRow();
                            client.setId(Integer.parseInt(ctb.getValueAt(row, 0).toString()));
                            client.setName(ctb.getValueAt(row, 1).toString());
                            client.setCCCD(ctb.getValueAt(row, 2).toString());
                            client.setAddress(ctb.getValueAt(row, 3).toString());
                            client.setPhone(ctb.getValueAt(row, 4).toString());
                            client.setLicense(ctb.getValueAt(row, 5).toString());
                            client.setType(ctb.getValueAt(row, 6).toString());
                            scvf.dispose();
                            ContractViewFrm contract = new ContractViewFrm(client, frame.getStaff(), frame.getBookedCar());
                            frame.dispose();
                            contract.setVisible(true);
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(null, "Choose a client", "Try Again", 1);
                            return;
                        }
                    }
                });
            }
        });
    }
}
