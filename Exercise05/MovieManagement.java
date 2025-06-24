package BTVN.Exercise05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManagement {
    public void addMovie(String title, String director, int year) {
        try (Connection conn = DriverManager.getConnection(Database.URL, Database.USER, Database.PASSWORD);
             CallableStatement stmt = conn.prepareCall("{CALL add_movie(?, ?, ?)}")) {
            stmt.setString(1, title);
            stmt.setString(2, director);
            stmt.setInt(3, year);
            stmt.execute();
            System.out.println("Thêm phim thành công.");
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm phim: " + e.getMessage());
        }
    }

    public List<Movie> listMovies() {
        List<Movie> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Database.URL, Database.USER, Database.PASSWORD);
             CallableStatement stmt = conn.prepareCall("{CALL list_movies()}")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("release_year")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách phim: " + e.getMessage());
        }
        return list;
    }

    public void updateMovie(int id, String title, String director, int year) {
        try (Connection conn = DriverManager.getConnection(Database.URL, Database.USER, Database.PASSWORD);
             CallableStatement stmt = conn.prepareCall("{CALL update_movie(?, ?, ?, ?)}")) {
            stmt.setInt(1, id);
            stmt.setString(2, title);
            stmt.setString(3, director);
            stmt.setInt(4, year);
            stmt.execute();
            System.out.println("Cập nhật phim thành công.");
        } catch (SQLException e) {
            System.err.println("Lỗi cập nhật phim: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        try (Connection conn = DriverManager.getConnection(Database.URL, Database.USER, Database.PASSWORD);
             CallableStatement stmt = conn.prepareCall("{CALL delete_movie(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Xóa phim thành công.");
        } catch (SQLException e) {
            System.err.println("Lỗi xóa phim: " + e.getMessage());
        }
    }
}
