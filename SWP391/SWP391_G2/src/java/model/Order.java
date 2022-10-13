/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Order {

    private int id;
    private String username;
    private Car car;
    private String renterFullname;
    private String renterEmail;
    private String renterAddress;
    private String renterCity;
    private int renterPhone;
    private Date pickupDate;
    private Date dropoffDate;
    private String pickupAddress;
    private String dropoffAddress;
    private double amount;
    private String status;

    public Order() {
    }

    public Order(int id, String username, Car car, String renterFullname, String renterEmail, String renterAddress, String renterCity, int renterPhone, String pickupAddress, String dropoffAddress, Date pickupDate, Date dropoffDate, double amount, String status) {
        this.id = id;
        this.username = username;
        this.car = car;
        this.renterFullname = renterFullname;
        this.renterEmail = renterEmail;
        this.renterAddress = renterAddress;
        this.renterCity = renterCity;
        this.renterPhone = renterPhone;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.pickupAddress = pickupAddress;
        this.dropoffAddress = dropoffAddress;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getRenterFullname() {
        return renterFullname;
    }

    public void setRenterFullname(String renterFullname) {
        this.renterFullname = renterFullname;
    }

    public String getRenterEmail() {
        return renterEmail;
    }

    public void setRenterEmail(String renterEmail) {
        this.renterEmail = renterEmail;
    }

    public String getRenterAddress() {
        return renterAddress;
    }

    public void setRenterAddress(String renterAddress) {
        this.renterAddress = renterAddress;
    }

    public String getRenterCity() {
        return renterCity;
    }

    public void setRenterCity(String renterCity) {
        this.renterCity = renterCity;
    }

    public int getRenterPhone() {
        return renterPhone;
    }

    public void setRenterPhone(int renterPhone) {
        this.renterPhone = renterPhone;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDropoffAddress() {
        return dropoffAddress;
    }

    public void setDropoffAddress(String dropoffAddress) {
        this.dropoffAddress = dropoffAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", username=" + username + ", car=" + car + ", renterFullname=" + renterFullname + ", renterEmail=" + renterEmail + ", renterAddress=" + renterAddress + ", renterCity=" + renterCity + ", renterPhone=" + renterPhone + ", pickupDate=" + pickupDate + ", dropoffDate=" + dropoffDate + ", pickupAddress=" + pickupAddress + ", dropoffAddress=" + dropoffAddress + ", amount=" + amount + ", status=" + status + '}';
    }

    
}
