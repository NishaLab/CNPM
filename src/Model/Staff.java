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
public class Staff implements Serializable{

    public Staff() {
    }

    public Staff(String userName, String password, String name, String positon) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.positon = positon;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name + ", positon=" + positon + '}';
    }
    private int id;
    private String userName,password,name,positon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }
}
