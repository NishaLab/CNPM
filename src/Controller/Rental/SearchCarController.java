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
import DAO.CarDao;
import DAO.CarTypeDao;
import DAO.CarClassificationDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
                GregorianCalendar received = (GregorianCalendar) frame.getReceivedDate().getModel().getValue();
                GregorianCalendar returnn = (GregorianCalendar) frame.getReturnDate().getModel().getValue();
                Date receivedDate = received.getGregorianChange();
                Date returnDate = returnn.getGregorianChange();
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
                if (receivedDate == null || returnDate == null) {
                    JOptionPane.showMessageDialog(null, "Please Select Received Date and Return Date", "Try Again", 1);
                } else {
                    CarDao dao = new CarDao();
                    try {
                        frame.setCar(dao.searchCar(receivedDate, returnDate, name, typeId, classId));
                        ArrayList<Car> car = frame.getCar();
                        page.setText("1" + "/" + (int) Math.ceil((double) car.size() / 6));
                        frame.getCarCatalogPanel().removeAll();
                        for (int i = 0, j = 0; i < 6 && j < car.size(); i++, j++) {
                            frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i)));
                        }
                        frame.getCarCatalogPanel().revalidate();
                        frame.getCarCatalogPanel().repaint();
                        for (Car car1 : car) {
                            System.out.println(car1);
                        }
                    } catch (Exception f) {
                        f.printStackTrace();
                    }

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
                    frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i)));
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
                    frame.getCarCatalogPanel().add(new CarCatalogComponent(car.get(i)));
                }
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
