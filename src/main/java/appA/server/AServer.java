package appA.server;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import appA.logicbean.ALogicBean;
import appB.proxy.BProxyBean;

import org.omg.CosNaming.*;

public class AServer {
    public static void main(String[] args) {
        try {
            System.out.println("[AServer] ORB başlatılıyor...");
            ORB orb = ORB.init(args, null);

            // CORBA'da nesnelerin yaşam döngüsünü yönetmek
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();
            System.out.println("[AServer] POA Manager aktive edildi.");

            System.out.println("[AServer] BProxyBean oluşturuluyor...");
            BProxyBean bProxy = new BProxyBean(orb); // B'yi ORB üzerinden çözümle

            System.out.println("[AServer] ALogicBean oluşturuluyor...");
            ALogicBean service = new ALogicBean(bProxy);

            System.out.println("[AServer] AService için referans oluşturuluyor...");
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(service);
            appA.idl.AService href = appA.idl.AServiceHelper.narrow(ref);

            System.out.println("[AServer] ORB üzerinden Naming Service referansı alınıyor...");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        
            System.out.println("[AServer] Naming Service referansı 'NamingContextExt' tipine daraltılıyor...");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            System.out.println("[AServer] Daraltma işlemi tamamlandı. Naming Service başarıyla alındı.");
        
            System.out.println("[AServer] 'AService' için CORBA ismi üretiliyor...");
            NameComponent[] name = ncRef.to_name("AService");
        
            System.out.println("[AServer] 'AService' nesnesi Naming Service'e kaydediliyor...");
            ncRef.rebind(name, href);
            System.out.println("[AServer] 'AService' başarıyla Naming Service'e kaydedildi.");

            System.out.println("[AServer] A Server is running...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
