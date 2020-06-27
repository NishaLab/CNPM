/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Client;
import Model.ClientStat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Microsoft Windows
 */
public class ClientStatDao extends DAO{
    public ClientStatDao(){
        super();
    }
	public ArrayList<ClientStat> getCarBrandStat(Date startDate, Date endDate){
		ArrayList<ClientStat> result = new ArrayList<ClientStat>();
		ClientDao cd = new ClientDao();
		String sql = "SELECT c.id, c.name, IFNULL(SUM(X.income),0) as totalIncome, IFNULL(SUM(X.days),0) as totalDays"
                            +"FROM	(SELECT a.id AS carid, a.brand AS brandid,  "
                            +"(SELECT DATEDIFF(LEAST(b.returnDate,?), GREATEST(b.receivedDate,?)) FROM tblBookedCar b"
                            +"WHERE b.returnDate > ? AND b.receivedDate < ? AND b.tblCar_id = a.id  ) AS days,"
                            +"(SELECT DATEDIFF(LEAST(b.returnDate,?),GREATEST(b.receivedDate,?))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice FROM tblBookedCar b"
                            +"WHERE b.tblCar_id = a.id AND b.returnDate > ? AND b.receivedDate < ?) AS income"
                            +"FROM tblCar a "
                            +"ORDER BY income DESC ) AS X, tblcarbrand c"
                            +"WHERE X.brandid = c.id"
                            +"GROUP BY X.brandid"
                            +"ORDER BY totalIncome DESC" ;
                     
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sdf.format(endDate));
			ps.setString(2, sdf.format(startDate));
			ps.setString(3, sdf.format(startDate));
			ps.setString(4, sdf.format(endDate));
			ps.setString(5, sdf.format(endDate));
			ps.setString(6, sdf.format(startDate));
			ps.setString(7, sdf.format(startDate));
			ps.setString(8, sdf.format(endDate));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ClientStat cs = new ClientStat();
                                Client c = cd.getClientById(rs.getInt("id"));
				cs.setId(c.getId());
                                cs.setName(c.getName());
                                cs.setCCCD(c.getCCCD());
                                cs.setPhone(c.getPhone());
                                cs.setAddress(c.getAddress());
                                cs.setTotalContract(cs.getTotalContract());
                                cs.setTotalPayment(cs.getTotalPayment());
				result.add(cs);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
        return result;
        }
}
