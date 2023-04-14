import java.io.IOException;
import java.net.ServerSocket;

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost"; // Địa chỉ IP hoặc tên miền của máy chủ
        int startPort = 1; // Cổng bắt đầu quét
        int endPort = 1024; // Cổng kết thúc quét

        // Quét các cổng từ startPort đến endPort
        for (int port = startPort; port <= endPort; port++) {
            try {
                // Tạo một đối tượng ServerSocket với cổng hiện tại
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();

                // Nếu không có lỗi xảy ra, đồng nghĩa với việc có dịch vụ đang chạy trên cổng này
                System.out.println("Port " + port + " is open");
            } catch (IOException e) {
                // Nếu xảy ra lỗi, đồng nghĩa với việc không có dịch vụ đang chạy trên cổng này
                System.out.println("Port " + port + " is closed");
            }
        }
    }
}
