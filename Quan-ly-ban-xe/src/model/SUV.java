package model;

public class SUV extends Car{
    private int seats;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public SUV(String licensePlate, String brand, double price, int seats) {
        super(licensePlate, brand, price);
        this.seats = seats;
    }

    @Override
    public String displayInfo() {
        return "SUV{" +
                "seats=" + seats +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
