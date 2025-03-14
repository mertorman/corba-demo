package appB.proxy;

import appB.idl.BService;
import appB.idl.BServiceHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class BProxyBean {
    private BService service;

    public BProxyBean(ORB orb) {
        try {
            System.out.println("[BProxyBean] Naming Service'e bağlanılıyor...");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            service = BServiceHelper.narrow(ncRef.resolve_str("BService"));
            System.out.println("[BProxyBean] BService referansı başarıyla alındı.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData(String request) {
        System.out.println("[BProxyBean] getData çağrıldı. İstek: " + request);
        return service.getData(request);
    }
}
