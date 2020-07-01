/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import DAO.CarStatDao;
import Model.CarBrandStat;
import Model.CarStat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import java.sql.Connection;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Vu Minh Duc
 */
public class CarStatDaoTest {

    CarStatDao csd = new CarStatDao();

    @Test
    public void testgetCarBrandStatException1() {
        Date start = new GregorianCalendar(2020, Calendar.APRIL, 20).getTime();
        Date end = new GregorianCalendar(2020, Calendar.APRIL, 30).getTime();
        ArrayList<CarBrandStat> rs = csd.getCarBrandStat(start, end);
        Assert.assertNotNull(rs);
        Assert.assertEquals(4, rs.size());
        Assert.assertEquals(2, rs.get(0).getRentTime());
        Assert.assertEquals(6, rs.get(0).getTotalDay());
        Assert.assertEquals(33333.332, rs.get(0).getIncome(), 0.0001f);
    }

    @Test
    public void testgetCarBrandStatException2() {
        Date start = new GregorianCalendar(2020, Calendar.JANUARY, 20).getTime();
        Date end = new GregorianCalendar(2020, Calendar.JANUARY, 30).getTime();
        ArrayList<CarBrandStat> rs = csd.getCarBrandStat(start, end);
        Assert.assertNotNull(rs);
        Assert.assertEquals(4, rs.size());
        Assert.assertEquals(0, rs.get(0).getRentTime());
        Assert.assertEquals(0, rs.get(0).getTotalDay());
        Assert.assertEquals(0, rs.get(0).getIncome(), 0.000001f);
    }

    @Test
    public void getDetailsBrandStatException1() {
        Date start = new GregorianCalendar(2020, Calendar.APRIL, 1).getTime();
        Date end = new GregorianCalendar(2020, Calendar.APRIL, 30).getTime();
        ArrayList<CarStat> rs = csd.getDetailsBrandStat(start, end, 3);
        Assert.assertNotNull(rs);
        Assert.assertEquals(2, rs.size());
        Assert.assertEquals(1, rs.get(0).getRentTime());
        Assert.assertEquals(5, rs.get(0).getTotalDay());
        Assert.assertEquals(28000, rs.get(0).getIncome(), 0.000001f);
    }

    @Test
    public void getDetailsCarStatException1() {
        Date start = new GregorianCalendar(2020, Calendar.APRIL, 10).getTime();
        Date end = new GregorianCalendar(2020, Calendar.APRIL, 30).getTime();
        ArrayList<CarStat> rs = csd.getDetailsCarStat(start, end, 4);
        Assert.assertNotNull(rs);
        Assert.assertEquals(1, rs.size());
        Assert.assertEquals(4, rs.get(0).getTotalDay());
        Assert.assertEquals(6000, rs.get(0).getIncome(), 0.000001f);
        Assert.assertEquals(0, rs.get(0).getPenAmount(),0.000001f);
    }
    @Test
    public void getDetailsCarStatException2() {
        Date start = new GregorianCalendar(2020, Calendar.APRIL, 1).getTime();
        Date end = new GregorianCalendar(2020, Calendar.APRIL, 10).getTime();
        ArrayList<CarStat> rs = csd.getDetailsCarStat(start, end, 1);
        Assert.assertNotNull(rs);
        Assert.assertEquals(1, rs.size());
        Assert.assertEquals(1, rs.get(0).getTotalDay());
        Assert.assertEquals(1000, rs.get(0).getIncome(), 0.000001f);
        Assert.assertEquals(33.3333332, rs.get(0).getPenAmount(), 0.0001f);
    }
    @Test
    public void getDetailsCarStatException3() {
        Date start = new GregorianCalendar(2020, Calendar.APRIL, 30).getTime();
        Date end = new GregorianCalendar(2020, Calendar.MAY, 1).getTime();
        ArrayList<CarStat> rs = csd.getDetailsCarStat(start, end, 10);
        Assert.assertNotNull(rs);
        Assert.assertEquals(1, rs.size());
        Assert.assertEquals(1, rs.get(0).getTotalDay());
        Assert.assertEquals(6000, rs.get(0).getIncome(), 0.000001f);
        Assert.assertEquals(666.6667, rs.get(0).getPenAmount(), 0.0001f);  
    }
    @Test
    public void getDetailsCarStatException4(){
        Date start = new GregorianCalendar(2020, Calendar.APRIL, 20).getTime();
        Date end = new GregorianCalendar(2020, Calendar.MAY, 1).getTime();
        ArrayList<CarStat> rs = csd.getDetailsCarStat(start, end, 10);
        Assert.assertNotNull(rs);
        Assert.assertEquals(1, rs.size());
        Assert.assertEquals(2, rs.get(0).getTotalDay());
        Assert.assertEquals(12000, rs.get(0).getIncome(), 0.000001f);
        Assert.assertEquals(1333.33334, rs.get(0).getPenAmount(), 0.0001f);        
    }
}
