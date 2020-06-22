/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author LEGION
 */
public class Client implements Serializable{

    public Client() {
    }

    public Client(String name, String phone, String address, String CCCD, String license, String type) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.CCCD = CCCD;
        this.license = license;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", CCCD=" + CCCD + ", license=" + license + ", type=" + type + '}';
    }
    private int id;
    private String name,phone,address,CCCD,license,type;
}
