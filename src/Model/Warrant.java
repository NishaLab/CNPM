/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author LEGION
 */
public class Warrant implements Serializable {

    public Warrant() {
    }

    public Warrant(int id, String type, String desc, int value, Client client) {
        this.id = id;
        this.type = type;
        this.desc = desc;
        this.value = value;
        this.client = client;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Warrant{" + "id=" + id + ", type=" + type + ", desc=" + desc + ", value=" + value + ", client=" + client + '}';
    }

    public Warrant(String type, String desc, int value, Client client) {
        this.type = type;
        this.desc = desc;
        this.value = value;
        this.client = client;
    }

    public Object[] toObject() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return new Object[]{this.id, this.type, this.desc, formatter.format(this.value)};
    }
    private int id;
    private String type, desc;
    private int value;
    private Client client;
}
