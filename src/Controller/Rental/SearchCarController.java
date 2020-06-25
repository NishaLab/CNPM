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
        JLabel page = new JLabel();
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GregorianCalendar received = (GregorianCalendar) frame.getReceivedDate().getModel().getValue();
                GregorianCalendar returnn = (GregorianCalendar) frame.getReturnDate().getModel().getValue();
                Date receivedDate = received.getGregorianChange();
                Date returnDate = returnn.getGregorianChange();
                System.out.println(receivedDate);
                System.out.println(returnDate);
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
                        page.setText("1" + "/" + Math.ceil(car.size() / 6));
                        frame.getCarCatalogPanel().removeAll();
                        for (Car car1 : car) {
                            frame.getCarCatalogPanel().add(new CarCatalogComponent(car1));
                        }
                        frame.getCarCatalogPanel().revalidate();
                        frame.getCarCatalogPanel().repaint();
                    } catch (Exception f) {
                        f.printStackTrace();
                    }

                }

            }
        });
    }
}
