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

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public abstract String displayInfo();
}
