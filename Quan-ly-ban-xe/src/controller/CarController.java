package controller;

import model.Car;
import model.Inventory;
import java.io.*;
import java.util.List;

public class CarController {
    private Inventory inventory = Inventory.getInstance();

    public void saveInventoryToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : Inventory.getInstance().getCars()) {
                writer.write(car.toString());
                writer.newLine();
            }
            System.out.println("Danh sách tồn kho đã được ghi vào file: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
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
