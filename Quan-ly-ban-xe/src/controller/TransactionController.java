package controller;

import exception.CarNotFoundException;
import exception.CustomerNotFoundException;
import model.Car;
import model.Customer;
import model.Inventory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {
    private List<String> transactions = new ArrayList<>();
    private Inventory inventory = Inventory.getInstance();

    public void sellCar(String licensePlate, int customerId, CustomerController customerController)
            throws CarNotFoundException, CustomerNotFoundException {
        // Tìm xe theo biển số
        Car carToSell = null;
        for (Car car : inventory.getCars()) {
            if (car.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                carToSell = car;
                break;
            }
        }
        if (carToSell == null) {
            throw new CarNotFoundException("Xe không tồn tại trong kho.");
        }

        // Tìm khách hàng theo ID
        Customer customer = customerController.getCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Khách hàng không tồn tại.");
        }

        // Tạo giao dịch
        String transaction = "Xe " + carToSell.getLicensePlate() + " đã được bán cho khách hàng: " + customer.getName();
        transactions.add(transaction);

        // Xóa xe khỏi kho
        inventory.removeCar(carToSell);

        // Lưu giao dịch vào file
        saveTransactionToFile("transaction.txt", transaction);
        System.out.println(transaction);
    }

    public void saveTransactionToFile(String fileName, String transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(transaction);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu giao dịch: " + e.getMessage());
        }
    }

    public void printTransactionsFromFile(String fileName) {
        try (var reader = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
