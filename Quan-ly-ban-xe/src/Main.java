import controller.*;
import exception.CarNotFoundException;
import exception.CustomerNotFoundException;
import exception.DuplicateCustomerException;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarController carController = new CarController();
        CustomerController customerController = new CustomerController();
        TransactionController transactionController = new TransactionController();
        Inventory inventory = Inventory.getInstance();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Kiểm tra tồn kho và ghi ra file");
            System.out.println("3. Thêm xe vào kho");
            System.out.println("4. Bán xe");
            System.out.println("5. In lịch sử giao dịch");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            // Đảm bảo scanner đọc lựa chọn đúng và xử lý lỗi nhập không hợp lệ
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.println("Nhập thông tin khách hàng (ID, Tên, Email, SĐT): ");
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("SĐT: ");
                        String phone = scanner.nextLine();

                        Customer customer = new Customer(id, name, email, phone);
                        customerController.addCustomer(customer);
                        System.out.println("Thêm khách hàng thành công!");
                    } catch (DuplicateCustomerException | IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());

                    }
                    break;
                }
                case 2: {
                    System.out.println("Danh sách tồn kho:");
                    if (inventory.getCars().isEmpty()) {
                        System.out.println("Kho hiện tại không có xe nào.");
                    } else {
                        inventory.getCars().forEach(System.out::println);
                        carController.saveInventoryToFile("inventory.txt");
                        System.out.println("Danh sách tồn kho đã được ghi ra file inventory.txt");
                    }
                    break;
                }

                case 3: {
                    System.out.println("Chọn loại xe (1. Sedan, 2. SUV): ");
                    try {
                        int type = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập biển số: ");
                        String licensePlate = scanner.nextLine();
                        System.out.print("Nhập thương hiệu: ");
                        String brand = scanner.nextLine();
                        System.out.print("Nhập giá: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        if (type == 1) {
                            System.out.print("Nhập số cửa: ");
                            int numDoors = Integer.parseInt(scanner.nextLine());
                            Sedan sedan = new Sedan(licensePlate, brand, price, numDoors);
                            inventory.addCar(sedan);
                            System.out.println("Thêm xe sedan thành công!");
                        } else if (type == 2) {
                            System.out.print("Nhập số ghế: ");
                            int seats = Integer.parseInt(scanner.nextLine());
                            SUV suv = new SUV(licensePlate, brand, price, seats);
                            inventory.addCar(suv);
                            System.out.println("Thêm xe SUV thành công!");
                        } else {
                            System.out.println("Loại xe không hợp lệ.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng thử lại.");
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.print("Nhập biển số xe cần bán: ");
                        String licensePlate = scanner.nextLine();
                        System.out.print("Nhập ID khách hàng: ");
                        int customerId = Integer.parseInt(scanner.nextLine());

                        transactionController.sellCar(licensePlate, customerId, customerController);
                    } catch (CarNotFoundException | CustomerNotFoundException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("ID khách hàng phải là một số nguyên hợp lệ.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Lịch sử giao dịch:");
                    transactionController.printTransactionsFromFile("transaction.txt");
                    break;
                }
                case 6: {
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
                }
            }
        }
    }
}
