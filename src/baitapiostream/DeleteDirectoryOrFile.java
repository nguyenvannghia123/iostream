package baitapiostream;
import java.io.File;
import java.util.Scanner;

public class DeleteDirectoryOrFile {

    public static void main(String[] args) {
        // Nhập đường dẫn tới thư mục hoặc file từ người dùng
        String path = getInputPath();

        // Xác nhận và xóa thư mục hoặc file
        boolean deleted = deleteDirectoryOrFile(path);
        if (deleted) {
            System.out.println("Xóa thành công thư mục hoặc file: " + path);
        } else {
            System.out.println("Không thể xóa thư mục hoặc file: " + path);
        }
    }

    private static String getInputPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn tới thư mục hoặc file cần xóa: ");
        return scanner.nextLine();
    }

    private static boolean deleteDirectoryOrFile(String path) {
        try {
            File fileOrDirectory = new File(path);

            if (!fileOrDirectory.exists()) {
                System.out.println("Thư mục hoặc file không tồn tại: " + path);
                return false;
            }

            // Xóa thư mục nếu là thư mục
            if (fileOrDirectory.isDirectory()) {
                deleteDirectory(fileOrDirectory);
            } else { // Xóa file nếu là file
                return fileOrDirectory.delete();
            }

            return true; // Xóa thành công
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa thư mục hoặc file: " + e.getMessage());
            return false; // Xóa không thành công
        }
    }

    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file); // Đệ quy xóa thư mục con
                } else {
                    file.delete(); // Xóa file
                }
            }
        }
        directory.delete(); // Xóa thư mục sau khi các thư mục con và file con đã được xóa
    }
}

