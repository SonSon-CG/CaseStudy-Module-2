package model;

public class SUV extends Car {
    private int seats;

    public SUV(String licensePlate, String brand, double price, int seats) {
        super(licensePlate, brand, price);
        this.seats = seats;
    }

    @Override
    public String displayInfo() {
        return "SUV{" +
                "licensePlate='" + getLicensePlate() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", seats=" + seats +
                '}';
    }
}
