/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Vu Minh Duc
 */
public class CarBrandStat extends CarBrand implements Serializable {

    public CarBrandStat() {
        super();
    }

    public CarBrandStat(int totalDay, float income, int rentTime) {
        this.totalDay = totalDay;
        this.income = income;
        this.rentTime = rentTime;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public float getIncome() {
        return income;
    }

    public int getRentTime() {
        return rentTime;
    }

  
    
    private int totalDay;
    private float income;
    private int rentTime;
}
