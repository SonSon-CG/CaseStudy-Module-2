package model;

import java.io.Serializable;

public abstract class Car implements Serializable {
    private String licensePlate;
    private String brand;
    private double price;

    public Car(String licensePlate, String brand, double price) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.price = price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public abstract String displayInfo();
}
