import java.io.IOException;
import java.net.Socket;

public class ServiceChecker {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ServiceChecker <Address IP> <gate>");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            // Tạo đối tượng Socket để kết nối đến host và port cụ thể
            Socket socket = new Socket(host, port);
            System.out.println("Service active " + host + " gate " + port);
            // Đóng kết nối socket
            socket.close();
        } catch (IOException e) {
            System.out.println("Service not active " + host + " gate " + port);
        }
    }
}
