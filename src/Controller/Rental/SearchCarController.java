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
import DAO.CarDao;
import DAO.CarTypeDao;
import DAO.CarClassificationDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
        ArrayList<CarType> carType = this.frame.getTypeList();
        ArrayList<CarClassification> carClass = this.frame.getClassList();
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
