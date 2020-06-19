package Controller;

import DAO.*;
import Model.*;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList<Car> car = new ArrayList<>();
        CarDao carDao = new CarDao();
        try {
            car = carDao.searchCar("volvo", 1, 1);
            for (Car car1 : car) {
                System.out.print(car1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
