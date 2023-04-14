import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostNametoIP {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java HostNametoIP <hostname>");
            System.exit(1);
        }

        String hostname = args[0];

        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            for (int i = 0; i < addresses.length; i++) {
                System.out.println(addresses[i].getHostAddress());
            }
        } catch (UnknownHostException ex) {
            System.err.println("Could not find IP address for " + hostname);
        }
    }
}