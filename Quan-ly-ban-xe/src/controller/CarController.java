package controller;

import model.Car;
import model.Inventory;
import model.Sedan;

import java.io.*;
import java.util.List;

public class CarController {
    Car sedan1 = new Sedan("30A-00000","Toyota", 15000, 4);
    Car sedan2 = new Sedan("30A-11111","Toyota", 12000, 2);
private Inventory inventory = Inventory.getInstance();

    public void saveInventoryToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(inventory.getCars());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadInventoryFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            inventory.getCars().clear();
            inventory.getCars().addAll((List<Car>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

