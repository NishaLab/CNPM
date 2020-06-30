/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import DAO.WarrantDao;
import Model.Client;
import Model.Warrant;
import java.util.ArrayList;
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
public class WarrantDaoTest {

    private final WarrantDao dao = new WarrantDao();

    public WarrantDaoTest() {
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

//    @Test
//    public void testAddWarrant() {
//        Client client = new Client("hung", "1", "2", "3", "B", "Vip");
//        client.setId(1);
//        Warrant warrant = new Warrant("MotorBike", "Wave A Trang", 20000, client);
//        Assert.assertTrue(dao.addWarrant(warrant));
//        return;
//    }

    @Test
    public void testAddWarrant2() {
        Client client = new Client("hung", "1", "2", "3", "B", "Vip");
        client.setId(1);
        Warrant warrant = new Warrant("MotorBike", "Wave A Trang", 20000, client);
        Assert.assertTrue(dao.addWarrant(warrant));
        Assert.assertFalse(dao.addWarrant(warrant));
        return;
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
