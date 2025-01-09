package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    private List<Car> cars;

    private Inventory() {
        cars = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }
}
