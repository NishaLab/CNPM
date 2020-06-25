/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Vu Minh Duc
 */
public class CarBrand {

    public CarBrand() {
    }

    public CarBrand(int id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    private int id;
    private String name,des;
}
