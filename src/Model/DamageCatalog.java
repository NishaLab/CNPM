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
public class DamageCatalog implements Serializable{

    public DamageCatalog() {
    }

    public DamageCatalog(String type, String desc, int fee) {
        this.type = type;
        this.desc = desc;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "DamageCatalog{" + "id=" + id + ", type=" + type + ", desc=" + desc + ", fee=" + fee + '}';
    }
    private int id;
    private String type,desc;
    private int fee;
}
