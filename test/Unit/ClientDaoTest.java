package Unit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.ClientDao;
import Model.Client;
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
public class ClientDaoTest {

    private final ClientDao dao = new ClientDao();

    public ClientDaoTest() {
    }

    @Test
    public void testSearchClientException1() {
        String key = "xxxxxxxxxxx";
        ArrayList<Client> client = dao.searchClient(key);
        Assert.assertNotNull(client);
        Assert.assertEquals(0, client.size());
        return;
    }

    @Test
    public void testSearchClientException2() {
        String key = "DUC";
        ArrayList<Client> client = dao.searchClient(key);
        Assert.assertNotNull(client);
        Assert.assertEquals(1, client.size());
        return;
    }

//    @Test
//    public void testInsertClientException1() {
//        Client client = new Client("Hung Test", "12345", "Xuan Duc", "12345565", "B1", "Normal");
//        Assert.assertTrue(dao.addClient(client));
//        return;
//    }

    @Test
    public void testInsertClientException2() {
        Client client = new Client("Hung Test", "12345", "Xuan Duc", "12345565", "B1", "Normal");
        Assert.assertTrue(dao.addClient(client));
        Assert.assertFalse(dao.addClient(client));
        return;
    }
}
