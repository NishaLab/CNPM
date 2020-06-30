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

    public CarStat(int totalDay, int contractId, int rentTime, float income, float penAmount, String clientName) {
        this.totalDay = totalDay;
        this.contractId = contractId;
        this.rentTime = rentTime;
        this.income = income;
        this.penAmount = penAmount;
        this.clientName = clientName;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setPenAmount(float penAmount) {
        this.penAmount = penAmount;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public int getContractId() {
        return contractId;
    }

    public int getRentTime() {
        return rentTime;
    }

    public float getIncome() {
        return income;
    }

    public float getPenAmount() {
        return penAmount;
    }

    public String getClientName() {
        return clientName;
    }
    
    private int totalDay,contractId,rentTime;
    private float income;
    private float penAmount;
    private String clientName;
}
