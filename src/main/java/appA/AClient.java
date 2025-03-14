package appA;

import org.omg.CORBA.*;

import appA.idl.AService;
import appA.proxybean.AProxyBean;

public class AClient {
    public static void main(String[] args) {
        try {
            System.out.println("[AClient] ORB başlatılıyor...");
            ORB orb = ORB.init(args, null);

            System.out.println("[AClient] AProxyBean oluşturuluyor...");
            AProxyBean proxy = new AProxyBean(orb);

            System.out.println("[AClient] AServer referansı alınıyor...");
            AService serverRefA = proxy.getServerReferance();

            System.out.println("[AClient] processRequest çağrılıyor...");
            String response = serverRefA.processRequest("Hello from AClient!");

            System.out.println("[AClient] Yanıt alındı: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
