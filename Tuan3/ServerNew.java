import java.io.*;
import java.net.*;

public class ServerNew {
    public static void main(String[] args) {
        try {
            // Tạo ServerSocket để lắng nghe kết nối từ Client
            ServerSocket serverSocket = new ServerSocket(2023);
            System.out.println("Serverm Connect...");

            // Chấp nhận kết nối từ Client
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected!");

            // Tạo đối tượng đọc dữ liệu từ Client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Tạo đối tượng gửi dữ liệu từ Server đến Client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Đọc và xử lý xâu ký tự từ Client
            String input;
            while ((input = in.readLine()) != null) {
                // System.out.println("Server Input: " + input);
                // Biến đổi xâu ký tự thành xâu ký tự viết hoa
                String output = input.toUpperCase();
                // Gửi xâu ký tự viết hoa cho Client
                out.println(output);
                System.out.println("Server Output: " + output);
            }

            // Đóng kết nối
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
