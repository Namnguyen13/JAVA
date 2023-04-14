import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Tạo socket để kết nối đến Server
            Socket socket = new Socket("localhost", 2023);

            // Tạo đối tượng gửi dữ liệu từ Client đến Server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Gửi xâu ký tự từ Client đến Server
            String input = "Hello Server!";
            // System.out.println("Client input: " + input);
            out.println(input);

            // Tạo đối tượng đọc dữ liệu từ Server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Đọc xâu ký tự viết hoa từ Server
            String output = in.readLine();
            System.out.println("Client Output: " + output);

            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
