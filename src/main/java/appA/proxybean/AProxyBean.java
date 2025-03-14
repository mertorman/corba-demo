package appA.proxybean;

import appA.idl.AService;
import appA.idl.AServiceHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class AProxyBean {
    private AService service;

    public AProxyBean(ORB orb) {
        try {
            System.out.println("[AProxyBean] Naming Service'e bağlanılıyor...");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            service = AServiceHelper.narrow(ncRef.resolve_str("AService"));
            System.out.println("[AProxyBean] AService referansı başarıyla alındı.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AService getServerReferance() {
        return service;
    }

    public String processRequest(String request) {
        System.out.println("[AProxyBean] processRequest çağrıldı. İstek: " + request);
        return service.processRequest(request);
    }
}
