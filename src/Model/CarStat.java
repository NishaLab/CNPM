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

    public CarStat(int totalDay, int contractId, float amount, String clientName) {
        this.totalDay = totalDay;
        this.contractId = contractId;
        this.amount = amount;
        this.clientName = clientName;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    public float getAmount() {
        return amount;
    }

    public String getClientName() {
        return clientName;
    }
   
    
    private int totalDay,contractId;
    private float amount;
    private String clientName;
}
