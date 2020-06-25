/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import Model.BookedCar;
import Model.Car;
import javax.swing.JPanel;
import View.Rental.Component.CarCatalogComponent;
import View.Rental.Component.CartComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION
 */
public class CarCatalogComponentController {

    private CarCatalogComponent panel;

    public CarCatalogComponentController(CarCatalogComponent panel) {
        this.panel = panel;
    }

    public void init() {
        onclickImageAction();
    }

    public void onclickImageAction() {
        JLabel image = panel.getImageLabel();
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Car car = panel.getCar();
                ArrayList<Car> listCar = panel.getFrame().getChosen();
                ArrayList<BookedCar> bc = panel.getFrame().getBookedCar();

                if (JOptionPane.showConfirmDialog(null, "Do you want to rent " + car.getName(),
                        "Pick", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == 0) {
                    for (Car car1 : listCar) {
                        if (car.getId() == car1.getId()) {
                            JOptionPane.showMessageDialog(null, "You have already selected this car!", "Try Again", 1);
                            return;
                        }
                    }
                    GregorianCalendar received = (GregorianCalendar) panel.getFrame().getReceivedDate().getModel().getValue();
                    GregorianCalendar returnn = (GregorianCalendar) panel.getFrame().getReturnDate().getModel().getValue();
                    Date receivedDate = received.getTime();
                    Date returnDate = returnn.getTime();
                    BookedCar bookedCar = new BookedCar();
                    bookedCar.setCar(car);
                    bookedCar.setReceivedDate(receivedDate);
                    bookedCar.setReturnDate(returnDate);
                    bookedCar.setPenAmount(0);
                    long days = (bookedCar.getReturnDate().getTime() - bookedCar.getReceivedDate().getTime()) / (60 * 60 * 24 * 1000) + 1;
                    bookedCar.setTotalPrice(days*bookedCar.getCar().getPrice());
                    bc.add(bookedCar);
                    listCar.add(car);
                    panel.getFrame().getCartPanel().add(new CartComponent(car));
                    panel.getFrame().getCartPanel().revalidate();
                    panel.getFrame().getCartPanel().repaint();
                }

            }

        });
    }
}
