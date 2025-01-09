package model;

public class Sedan extends Car {
    private int numDoors;

    public Sedan(String licensePlate, String brand, double price, int numDoors) {
        super(licensePlate, brand, price);
        this.numDoors = numDoors;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "numDoors=" + numDoors +
                '}';
    }

    @Override
    public String displayInfo() {
        return "Sedan{" +
                "licensePlate='" + getLicensePlate() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", numDoors=" + numDoors +
                '}';
    }
}
