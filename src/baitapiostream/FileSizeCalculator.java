package baitapiostream;
import java.io.File;
import java.util.Scanner;

public class FileSizeCalculator {

    public static void main(String[] args) {
        // Nhập đường dẫn tới file từ người dùng
        String filePath = getInputFilePath();

        // Tính độ lớn của file và xuất ra màn hình
        long fileSize = calculateFileSize(filePath);
        if (fileSize != -1) {
            System.out.println("Độ lớn của file là: " + fileSize + " bytes");
        } else {
            System.out.println("Không thể tính được độ lớn của file. Đường dẫn không hợp lệ.");
        }
    }

    private static String getInputFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn tới file: ");
        return scanner.nextLine();
    }

    private static long calculateFileSize(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            return file.length(); // Trả về độ lớn của file (kích thước) trong bytes
        } else {
            return -1; // Trả về -1 nếu đường dẫn không hợp lệ hoặc không phải là file
        }
    }
}
