/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import Model.Client;
import Model.Contract;
import DAO.ContractDao;
import DAO.ClientDao;
import DAO.CarBrandDao;
import DAO.CarTypeDao;
import DAO.CarClassificationDao;
import DAO.StaffDao;
import Model.BookedCar;
import Model.Car;
import Model.CarBrand;
import Model.CarType;
import Model.CarClassification;
import Model.ContractWarrant;
import Model.Staff;
import Model.Warrant;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author LEGION
 */
public class ContractDaoTest {

    private ContractDao dao = new ContractDao();

    public ContractDaoTest() {
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
//    @Test
//    public void testAddContract1() {
//        Contract contract = new Contract();
//        contract = dao.getContractById(24);
//        System.out.println(contract);
//        Assert.assertFalse(dao.addContract(contract));
//        return;
//    }

    @Test
    public void testAddContract2() throws SQLException {
        ClientDao clientdao = new ClientDao();
        StaffDao staffdao = new StaffDao();
        CarTypeDao typeDao = new CarTypeDao();
        CarClassificationDao classDao = new CarClassificationDao();
        CarBrandDao brandDao = new CarBrandDao();
        Contract contract1 = new Contract();
        Contract contract2 = new Contract();

        //set up du lieu test
        ArrayList<BookedCar> bc = new ArrayList<>();
        Car car = new Car(15, "Mercedes C200", "", "30B14017", 6000, "Free",
                brandDao.getCarBrandById(2), typeDao.getCarTypeById(6), classDao.getCarClassById(4));
        Date receivedDate = new GregorianCalendar(2020, Calendar.MARCH, 01, 07, 00, 00).getTime();
        Date returnDate = new GregorianCalendar(2020, Calendar.MARCH, 10, 07, 00, 00).getTime();
        BookedCar booked = new BookedCar();
        booked.setCar(car);
        booked.setReceivedDate(receivedDate);
        booked.setReturnDate(returnDate);
        booked.setPenAmount(0);
        booked.setTotalPrice(10000);
        bc.add(booked);
        Client client1 = clientdao.getClientById(1);
        Client client2 = clientdao.getClientById(2);
        Staff staff1 = new Staff("hung", "hung", "hung", "receptionist");
        staff1.setId(1);
        Date bookingdate = new Date();
        contract1.setCar(bc);
        contract2.setCar(bc);
        contract1.setBookingDate(bookingdate);
        contract2.setBookingDate(bookingdate);
        contract1.setStaff(staff1);
        contract2.setStaff(staff1);
        contract1.setClient(client1);
        contract2.setClient(client2);
        Warrant war1 = new Warrant("MotorBike", "Dream trang", 10000, client2);
        war1.setId(3);
        Warrant war2 = new Warrant("MotorBike", "Dream Den", 10000, client1);
        war2.setId(8);
        ContractWarrant conwar1 = new ContractWarrant(bookingdate, returnDate, war1);
        ContractWarrant conwar2 = new ContractWarrant(bookingdate, returnDate, war2);
        ArrayList<ContractWarrant> listcon1 = new ArrayList<>();
        listcon1.add(conwar1);
        ArrayList<ContractWarrant> listcon2 = new ArrayList<>();
        listcon2.add(conwar2);
        contract1.setConWarrant(listcon1);
        contract2.setConWarrant(listcon2);
        contract1.setAmount(20000);
        contract2.setAmount(20000);

        //end set up du lieu test
        Assert.assertTrue(dao.addContract(contract1));
        Assert.assertFalse(dao.addContract(contract2));
        return;
    }
}
