import java.io.*;
import java.net.*;

public class ClientNew {
    public static void main(String[] args) {
        try {
            // Tạo socket để kết nối đến Server
            Socket socket = new Socket("localhost", 2023);

            // Tạo đối tượng gửi dữ liệu từ Client đến Server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Tạo đối tượng đọc dữ liệu từ Server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Nhập xâu ký tự từ bàn phím và gửi cho Server
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while (true) {
                System.out.println("Client Input (nhap 'exit' de thoat): ");
                input = br.readLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                out.println(input);
                System.out.println("Client Input: " + input);

                // Đọc xâu ký tự viết hoa từ Server
                String output = in.readLine();
                // System.out.println("Client nhận: " + output);
            }

            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
