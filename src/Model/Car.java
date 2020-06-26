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
    public Car(){
        
    }   

    public Car(int id, String name, String desc, String regPlate, int price, String state, CarBrand brand, CarType type, CarClassification classs) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.regPlate = regPlate;
        this.price = price;
        this.state = state;
        this.brand = brand;
        this.type = type;
        this.classs = classs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRegPlate(String regPlate) {
        this.regPlate = regPlate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public void setClasss(CarClassification classs) {
        this.classs = classs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public int getPrice() {
        return price;
    }

    public String getState() {
        return state;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public CarType getType() {
        return type;
    }

    public CarClassification getClasss() {
        return classs;
    }
    
    private int id;
    private String name,desc,regPlate;
    private int price;
    private String state;
    private CarBrand brand;
    private CarType type;
    private CarClassification classs;
}
