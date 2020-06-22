/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */

public class Store implements Serializable{

    public Store() {
    }

    public Store(String name, String address, String phone, String desc, ArrayList<Car> car, ArrayList<Staff> staff) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.desc = desc;
        this.car = car;
        this.staff = staff;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Car> getCar() {
        return car;
    }

    public void setCar(ArrayList<Car> car) {
        this.car = car;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Store{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", desc=" + desc + ", car=" + car + ", staff=" + staff + '}';
    }
    private int id;
    private String name,address,phone,desc;
    private ArrayList<Car> car;
    private ArrayList<Staff> staff;
    
}
