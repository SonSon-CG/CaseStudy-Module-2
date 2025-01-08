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
                case 2:
                    // kiểm tra tồn kho
                case 3:
                    //thêm xe
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
