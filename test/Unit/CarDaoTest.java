/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.Car;
import DAO.CarDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;

/**
 *
 * @author LEGION
 */
public class CarDaoTest {

    private final CarDao dao = new CarDao();

    public CarDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /*
    --------[---------]------- // received '2020-06-01 07:00:00' && return '2020-06-10 07:00:00'
    Case no1 
    [-----]-------------------  // free
    Case no2
    --------------------[----]  // free
    Case no3
    -----[----]---------------
    Case no 4
    -----------[---]----------
    Case no 5
    ------[-----------]--------
    Case no 6
    --------------[--------]--
    Case no 7
    -----[----------------]---
    Case no 8
    -----[----------------]---
    Case no 9
    -----[---------]-----------
    
     */
    @Test
    public void testSearchFreeCar1() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.APRIL, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.APRIL, 10, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(5, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar2() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.JULY, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JULY, 10, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(5, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar3() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.APRIL, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 5, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar4() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.JUNE, 03, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 06, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar5() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.APRIL, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 10, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar6() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.JUNE, 05, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 12, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar7() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.APRIL, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 12, 07, 00, 00).getTime();
        System.out.println(receivedDate);
        System.out.println(returnDate);

        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertNotNull(listCar);
        Assert.assertEquals(3, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar8() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.JUNE, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 10, 07, 00, 00).getTime();
        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertEquals(3, listCar.size());
        return;
    }

    @Test
    public void testSearchFreeCar9() {
        String key = "";
        Date receivedDate = new GregorianCalendar(2020, Calendar.JUNE, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.JUNE, 12, 07, 00, 00).getTime();
        ArrayList<Car> listCar = new ArrayList<>();
        listCar = dao.searchCar(receivedDate, returnDate, key, 1, 1);
        for (Car car : listCar) {
            System.out.println(car.getName());
        }
        Assert.assertEquals(3, listCar.size());
        return;
    }
}
