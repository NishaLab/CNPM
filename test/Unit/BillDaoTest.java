/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import DAO.BillDao;
import DAO.ContractDao;
import Model.Bill;
import Model.Client;
import Model.Contract;
import Model.Staff;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LEGION
 */
public class BillDaoTest {
    private BillDao dao = new BillDao();
    public BillDaoTest() {
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
    @Test
    public void testInsertBill() {
        Staff staff = new Staff("hung", "hung", "hung", "Receptionist");
        staff.setId(1);
        ContractDao contractDao = new ContractDao();
        Contract contract = contractDao.getContractById(37);
        Bill bill = new Bill();
        bill.setContract(contract);
        bill.setAmount(20000);
        bill.setNote("Foo");
        bill.setPaymentDate("2020-03-04");
        bill.setPaymentType("Cash");
        bill.setStaff(staff);
        Assert.assertTrue(dao.addBill(bill));;
        return;
    }
}
