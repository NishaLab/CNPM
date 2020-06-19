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

public class Car implements Serializable{

    public Car() {
    }
    
    public Car(String name, String brand, String desc, int price, String state, CarType type, CarClassification classs) {
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
        this.state = state;
        this.type = type;
        this.classs = classs;
    }
    public Car(Car car) {
        this.name = car.getName();
        this.brand = car.getBrand();
        this.desc = car.getDesc();
        this.price = car.getPrice();
        this.state = car.getState();
        this.type = car.getType();
        this.classs = car.getClasss();
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarClassification getClasss() {
        return classs;
    }

    public void setClasss(CarClassification classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", brand=" + brand + ", desc=" + desc + ", price=" + price + ", state=" + state + ", type=" + type + ", classs=" + classs + '}';
    }
    private int id;
    private String name,brand,desc;
    private int price;
    private String state;
    private CarType type;
    private CarClassification classs;
    
    
}
