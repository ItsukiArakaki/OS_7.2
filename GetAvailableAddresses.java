import java.net.*;
import java.util.Enumeration;

public class GetAvailableAddresses {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isLoopback() || !iface.isUp()) {
                    continue; 
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    System.out.println("Interface: " + iface.getDisplayName());
                    System.out.println("IP Address: " + addr.getHostAddress());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}