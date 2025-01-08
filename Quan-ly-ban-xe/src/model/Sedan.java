package model;

public class Sedan extends Car{
    private int numDoors;

    public Sedan(String licensePlate, String brand, double price, int numDoors) {
        super(licensePlate, brand, price);
        this.numDoors = numDoors;
    }

    @Override
    public String displayInfo() {
        return "Sedan{" +
                "numDoors=" + numDoors +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
