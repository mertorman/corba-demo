package appB;

import org.omg.CORBA.*;

import appB.proxy.BProxyBean;

public class BClient {
    public static void main(String[] args) {
        try {
            System.out.println("[BClient] ORB başlatılıyor...");
            ORB orb = ORB.init(args, null);
            System.out.println("[BClient] BProxyBean oluşturuluyor...");
            BProxyBean proxy = new BProxyBean(orb);
            System.out.println("[BClient] getData çağrılıyor...");
            String response = proxy.getData("Hello from BClient!");
            System.out.println("Response from B: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
