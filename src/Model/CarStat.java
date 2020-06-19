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

    public CarStat(int totalRentTime, int amount, Date bookingDate) {
        super();
        this.totalRentTime = totalRentTime;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    public CarStat(Car car ,int totalRentTime, int amount, Date bookingDate) {
        super(car);
        this.totalRentTime = totalRentTime;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    public int getTotalRentTime() {
        return totalRentTime;
    }

    public void setTotalRentTime(int totalRentTime) {
        this.totalRentTime = totalRentTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "CarStat{" + "totalRentTime=" + totalRentTime + ", amount=" + amount + ", bookingDate=" + bookingDate + '}';
    }

    private int totalRentTime, amount;
    private Date bookingDate;
}
