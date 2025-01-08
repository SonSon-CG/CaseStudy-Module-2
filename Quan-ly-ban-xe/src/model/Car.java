package model;

public abstract class Car {
    public String licensePlate;
    public String brand;
    public double price;

    public Car(String licensePlate, String brand, double price) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.price = price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String displayInfo();
}
