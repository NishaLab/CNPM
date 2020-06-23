/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LEGION
 */
public class DAO {

    public static Connection conn;

    public DAO() {
        if (conn == null) {
            String url = "jdbc:mysql://localhost:3306/cnpm?useSSL=false";
            String username = "root";
            String password = "123456";
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
