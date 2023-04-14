import java.net.MalformedURLException;
import java.net.URL;

public class URLParser {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java URLParser <URL>");
            return;
        }

        String urlString = args[0];

        try {
            // Tạo đối tượng URL từ chuỗi URL đầu vào
            URL url = new URL(urlString);

            // Lấy các thành phần của URL
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            String ref = url.getRef();

            // In ra các thành phần của URL
            System.out.println("Protocol: " + protocol);
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Ref: " + ref);

        } catch (MalformedURLException e) {
            System.out.println("Errol: - " + e.getMessage());
        }
    }
}
