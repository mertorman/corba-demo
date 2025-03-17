package appB;

import org.omg.CORBA.*;
import appB.idl.BService;
import appB.proxy.BProxyBean;

public class BClient {
    public static void main(String[] args) {
        try {
            System.out.println("[BClient] ORB başlatılıyor...");
            ORB orb = ORB.init(args, null);
            System.out.println("[BClient] BProxyBean oluşturuluyor...");
            BProxyBean proxy = new BProxyBean(orb);
            System.out.println("[BClient] BServer referansı alınıyor...");
            BService serverRefB = proxy.getServerReferance();
            System.out.println("[BClient] getData çağrılıyor...");
            String response = serverRefB.getData("Hello from BClient!");
            System.out.println("Response from B: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
