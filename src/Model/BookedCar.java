/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LEGION
 */
public class BookedCar implements Serializable{

    public BookedCar() {
    }

    public BookedCar(Date receivedDate, Date returnDate, float totalPrice, float penAmount, ArrayList<Penalty> pen, Car car) {
        this.receivedDate = receivedDate;
        this.returnDate = returnDate;
        this.totalPrice = totalPrice;
        this.penAmount = penAmount;
        this.pen = pen;
        this.car = car;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getPenAmount() {
        return penAmount;
    }

    public void setPenAmount(float penAmount) {
        this.penAmount = penAmount;
    }

    public ArrayList<Penalty> getPen() {
        return pen;
    }

    public void setPen(ArrayList<Penalty> pen) {
        this.pen = pen;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookedCar{" + "id=" + id + ", receivedDate=" + receivedDate + ", returnDate=" + returnDate + ", totalPrice=" + totalPrice + ", penAmount=" + penAmount + ", pen=" + pen + ", car=" + car + '}';
    }
    private int id;
    private Date receivedDate,returnDate;
    private float totalPrice,penAmount;
    private ArrayList<Penalty> pen;
    private Car car;
}
