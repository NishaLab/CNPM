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
public class ContractWarrant implements Serializable{

    public ContractWarrant() {
    }

    public ContractWarrant(Date checkIn, Date checkOut, Warrant warrant) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.warrant = warrant;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Warrant getWarrant() {
        return warrant;
    }

    public void setWarrant(Warrant warrant) {
        this.warrant = warrant;
    }

    @Override
    public String toString() {
        return "ContractWarrant{" + "checkIn=" + checkIn + ", checkOut=" + checkOut + ", warrant=" + warrant + '}';
    }
    private Date checkIn,checkOut;
    private Warrant warrant;
    
}
