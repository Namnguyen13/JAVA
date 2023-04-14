import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Tạo ServerSocket để lắng nghe kết nối từ Client
            ServerSocket serverSocket = new ServerSocket(2023);
            System.out.println("Server connect ...");

            // Chấp nhận kết nối từ Client
            Socket socket = serverSocket.accept();
            System.out.println("Client connect!");

            // Tạo đối tượng đọc dữ liệu từ Client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Đọc xâu ký tự từ Client
            String input = in.readLine();
            System.out.println("Server input: " + input);

            // Biến đổi xâu ký tự thành xâu ký tự viết hoa
            String output = input.toUpperCase();

            // Tạo đối tượng gửi dữ liệu từ Server đến Client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Gửi xâu ký tự viết hoa cho Client
            out.println(output);
            // System.out.println("Server Output: " + output);

            // Đóng kết nối
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
