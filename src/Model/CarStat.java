/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LEGION
 */
public class CarStat extends Car implements Serializable {

    public CarStat() {
        super();
    }

    public CarStat(int totalDay, float amount) {
        this.totalDay = totalDay;
        this.amount = amount;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public float getAmount() {
        return amount;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
    
    private int totalDay;
    private float amount;
}
