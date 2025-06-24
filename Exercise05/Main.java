package BTVN.Exercise05;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final MovieManagement manager = new MovieManagement();

    public static void main(String[] args) {
        while (true){
            System.out.println("MENU QUẢN LÝ PHIM:");
            System.out.println("1. Thêm phim");
            System.out.println("2. Hiển thị danh sách phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Xóa phim");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    addMovie();
                    break;
                case 2:
                    showMovies();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    System.out.println("Thoát");
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        }
    }

private static void addMovie() {
    String title = inputNotEmpty("Nhập tiêu đề phim: ");
    String director = inputNotEmpty("Nhập đạo diễn: ");
    int year = inputInt("Nhập năm phát hành: ");
    manager.addMovie(title, director, year);
}

    private static void showMovies() {
        List<Movie> movies = manager.listMovies();
        if (movies.isEmpty()) {
            System.out.println("Không có phim nào.");
        } else {
            movies.forEach(m -> System.out.printf("ID: %d | Tên: %s | Đạo diễn: %s | Năm: %d%n",
                    m.getId(), m.getTitle(), m.getDirector(), m.getReleaseYear()));
        }
    }

    private static void updateMovie() {
        int id = inputInt("Nhập ID phim cần sửa: ");
        String title = inputNotEmpty("Tiêu đề mới: ");
        String director = inputNotEmpty("Đạo diễn mới: ");
        int year = inputInt("Năm phát hành mới: ");
        manager.updateMovie(id, title, director, year);
    }

    private static void deleteMovie() {
        int id = inputInt("Nhập ID phim cần xóa: ");
        manager.deleteMovie(id);
    }

    // ===== Hàm nhập có kiểm tra =====
    private static String inputNotEmpty(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Không được để trống.");
        }
    }

    private static int inputInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
    }
}
