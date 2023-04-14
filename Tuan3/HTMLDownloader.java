import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLDownloader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java HTMLDownloader <URL>");
            return;
        }

        String urlString = args[0];

        try {
            // Tạo đối tượng URL từ chuỗi URL đầu vào
            URL url = new URL(urlString);

            // Mở kết nối HTTP đến URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Đọc dữ liệu từ luồng đầu vào của kết nối
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder htmlContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                htmlContent.append(line);
            }
            reader.close();

            // In ra mã HTML của trang web
            System.out.println("Mã HTML của trang web " + urlString + ":");
            System.out.println(htmlContent.toString());

        } catch (IOException e) {
            System.out.println("Errol: Do not connecting to URL - " + e.getMessage());
        }
    }
}
