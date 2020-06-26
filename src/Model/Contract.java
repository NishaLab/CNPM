/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LEGION
 */
public class Contract {

    public Contract() {
    }

    public Contract(Date bookingDate, float amount, boolean state, ArrayList<ContractWarrant> conWarrant, ArrayList<BookedCar> car, Staff staff, Client client) {
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.state = state;
        this.conWarrant = conWarrant;
        this.car = car;
        this.staff = staff;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<ContractWarrant> getConWarrant() {
        return conWarrant;
    }

    public void setConWarrant(ArrayList<ContractWarrant> conWarrant) {
        this.conWarrant = conWarrant;
    }

    public ArrayList<BookedCar> getCar() {
        return car;
    }

    public void setCar(ArrayList<BookedCar> car) {
        this.car = car;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Contract{" + "id=" + id + ", bookingDate=" + bookingDate + ", amount=" + amount + ", state=" + state + ", conWarrant=" + conWarrant + ", car=" + car + ", staff=" + staff + ", client=" + client + '}';
    }
    private int id;
    private Date bookingDate;
    private float amount;
    private boolean state;
    private ArrayList<ContractWarrant> conWarrant;
    private ArrayList<BookedCar> car;
    private Staff staff;
    private Client client;
    
}
