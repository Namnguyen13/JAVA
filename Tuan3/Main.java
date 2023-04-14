import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Main <hostname>");
            System.exit(1);
        }

        String hostname = args[0];

        try {
            InetAddress address = InetAddress.getByName(hostname);
            System.out.println("IP address: " + address.getHostAddress());
            byte[] bytes = address.getAddress();
            int classValue = (bytes[0] & 0xFF) >> 6;
            String classString;
            switch (classValue) {
                case 0:
                case 1:
                    classString = "A";
                    break;
                case 2:
                    classString = "B";
                    break;
                case 3:
                    classString = "C";
                    break;
                case 4:
                    classString = "D";
                    break;
                default:
                    classString = "E";
                    break;
            }
            System.out.println("Address class: " + classString);
        } catch (UnknownHostException ex) {
            System.err.println("Could not find IP address for " + hostname);
        }
    }
}