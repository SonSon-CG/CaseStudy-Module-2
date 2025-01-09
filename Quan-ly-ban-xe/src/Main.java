import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Kiểm tra tồn kho và ghi ra file");
            System.out.println("3. Thêm xe vào kho");
            System.out.println("4. Bán xe");
            System.out.println("5. In lịch sử giao dịch");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //thêm khách hàng
                {
                    System.out.println("Nhập thông tin khách hàng (ID, Tên, Email, SĐT): ");
                    System.out.println("Nhập ID: ");
                    int id = sc.nextInt();
                    System.out.println("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập Email: ");
                    String email = sc.nextLine();
                    System.out.println("Nhập SĐT: ");
                    String phone = sc.nextLine();

                }
                case 2:
                    // kiểm tra tồn kho
                case 3:
                    System.out.println("Bạn muốn thêm Sedan hay SUV? ");
                    System.out.println("1.Sedan / 2.SUV");
                    int cartype = sc.nextInt();
                    System.out.println("Nhập biển số");
                    System.out.println("Nhập thương hiệu");
                    System.out.println("Nhập giá");
                case 4:
                    //bán xe
                    // nhập biển số xe
                                    // kiểm tra xe trong kho
                    // nhập ID khách
                                    // kiểm tra khách
                    // bán xe, remove ra khỏi kho
                    // tạo giao dịch, ghi vào lịch sử
                    // thông báo bán thành công
                    //
                case 5:
                    // in lịch sử giao dịch ra file
                case 6:

                    System.out.println(" Thoát chương trình ");
                default:
                    System.out.println(" Lựa chọn không hợp lệ ");
            }

            }
        }
    }
