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
public class CarType implements Serializable{

    public CarType(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public CarType() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CarType{" + "id=" + id + ", name=" + name + ", desc=" + desc + '}';
    }
    private int id;
    private String name,desc;
}
