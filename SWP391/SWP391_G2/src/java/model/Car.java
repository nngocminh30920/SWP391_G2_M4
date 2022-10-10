/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Car {

    private int id;
    private String owner;
    private String brand;
    private String model;
    private String type;
    private String tranmission;
    private int seat;
    private int door;
    private double price;
    private String image;
    private String description;

    public Car() {
    }

    public Car(int id, String owner, String brand, String model, String type, String tranmission, int seat, int door, double price, String image, String description) {
        this.id = id;
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.tranmission = tranmission;
        this.seat = seat;
        this.door = door;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTranmission() {
        return tranmission;
    }

    public void setTranmission(String tranmission) {
        this.tranmission = tranmission;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
