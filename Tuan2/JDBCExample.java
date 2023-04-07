// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/qlsinhvien"; // Đường dẫn cơ sở dữ liệu
        String user = "root"; // Tên đăng nhập cơ sở dữ liệu
        String password = "130503"; // Mật khẩu đăng nhập cơ sở dữ liệu

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Kết nối thành công!");

            // Truy vấn thông tin sinh viên học tại Khoa Công nghệ Thông Tin
            try (Statement stmt = conn.createStatement()) {
                String query = "SELECT * FROM SinhVien WHERE Khoa = 'Công nghệ Thông Tin'";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int maSV = rs.getInt("MaSV");
                    String tenSV = rs.getString("Tensv");
                    String khoa = rs.getString("Khoa");
                    System.out.println("Mã SV: " + maSV + ", Tên SV: " + tenSV + ", Khoa: " + khoa);
                }
            }

            // Xóa một bản ghi
            try (Statement stmt = conn.createStatement()) {
                String query = "DELETE FROM SinhVien WHERE MaSV = ?";
                int maSV = 1; // Mã sinh viên cần xóa
                java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, maSV);
                int rowsAffected = preparedStmt.executeUpdate();
                System.out.println("Số bản ghi bị xóa: " + rowsAffected);
            }

            // Chèn vào một bản ghi mới
            try (Statement stmt = conn.createStatement()) {
                String query = "INSERT INTO SinhVien (Tensv, Khoa) VALUES (?, ?)";
                String tenSV = "Nguyen Van A"; // Tên sinh viên mới
                String khoa = "Công nghệ Thông Tin"; // Khoa của sinh viên mới
                java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, tenSV);
                preparedStmt.setString(2, khoa);
                int rowsAffected = preparedStmt.executeUpdate();
                System.out.println("Số bản ghi được chèn: " + rowsAffected);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
