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
public class ClientStat extends Client implements Serializable {
    private int totalPayment, totalContract, totalDay;
    private float price, pen;
    private String CName;
    
    public ClientStat() {
        super();
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getTotalContract() {
        return totalContract;
    }

    public void setTotalContract(int totalContract) {
        this.totalContract = totalContract;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPen() {
        return pen;
    }

    public void setPen(float pen) {
        this.pen = pen;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }
  
    
    
}