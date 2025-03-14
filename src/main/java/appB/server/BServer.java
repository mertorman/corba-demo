package appB.server;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import appB.logic.BLogicBean;
import appB.proxy.BProxyBean;

import org.omg.CosNaming.*;

public class BServer {
    public static void main(String[] args) {
        try {
            System.out.println("[BServer] ORB başlatılıyor...");
            ORB orb = ORB.init(args, null);

            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();
            System.out.println("[BServer] POA Manager aktive edildi.");

            System.out.println("[BServer] BLogicBean oluşturuluyor...");
            BLogicBean service = new BLogicBean();

            System.out.println("[BServer] BProxyBean oluşturuluyor...");
            BProxyBean bProxy = new BProxyBean(orb); // Kendi LogicBean'ini ORB üzerinden al

            System.out.println("[BServer] BService için referans oluşturuluyor...");
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(service);
            appB.idl.BService href = appB.idl.BServiceHelper.narrow(ref);

            System.out.println("[BServer] Naming Service'e bağlanıyor...");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            ncRef.rebind(ncRef.to_name("BService"), href);

            System.out.println("[BServer] B Server is running...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
