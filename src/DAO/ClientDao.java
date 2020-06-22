/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Client;

/**
 *
 * @author LEGION
 */
public class ClientDao extends DAO {

    public ArrayList<Client> searchClient(String key) {
        ArrayList<Client> result = new ArrayList<Client>();
        String sql = "SELECT * FROM tblclient WHERE name LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setCCCD(rs.getString("CCCD"));
                client.setAddress(rs.getString("address"));
                client.setPhone(rs.getString("phone"));
                client.setLicense(rs.getString("license"));
                client.setType(rs.getString("type"));
                result.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Client getClientById(int key) {
        Client client = null;
        String sql = "SELECT * FROM tblclient WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setCCCD(rs.getString("CCCD"));
                client.setAddress(rs.getString("address"));
                client.setPhone(rs.getString("phone"));
                client.setLicense(rs.getString("license"));
                client.setType(rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public boolean addClient(Client client) {
        String sql = "INSERT INTO tblclient(name, cccd, address, phone, license, type) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCCCD());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getPhone());
            ps.setString(5, client.getLicense());
            ps.setString(6, client.getType());

            ps.executeUpdate();

            //get id of the new inserted client
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getInt(1));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
