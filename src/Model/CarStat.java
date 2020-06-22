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

    public CarStat(int totalRentTime, int amount) {
        super();
        this.totalRentTime = totalRentTime;
        this.amount = amount;
    }

    public int getTotalRentTime() {
        return totalRentTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setTotalRentTime(int totalRentTime) {
        this.totalRentTime = totalRentTime;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    private int totalRentTime, amount;
}
