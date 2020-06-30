/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import DAO.BillDao;
import DAO.ContractDao;
import Model.Client;
import Model.Contract;
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
        Client client = new Client("Hung Test 2", "12345999", "Xuan Duc", "12345565", "B1", "Normal");
        ContractDao contractDao = new ContractDao();

        return;
    }
}
