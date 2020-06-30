/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import DAO.CarStatDao;
import Model.CarBrandStat;
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
    public void getDetailsCarStatException1() {
        Date start = new GregorianCalendar(2020, Calendar.APRIL,1).getTime();
        Date end = new GregorianCalendar(2020, Calendar.APRIL,30).getTime();
        
    }
}
