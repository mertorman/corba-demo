package appB.logic;
import appB.idl.BServicePOA;

public class BLogicBean extends BServicePOA {

    public BLogicBean() {
        System.out.println("[BLogicBean] BLogicBean oluşturuldu.");
    }

    @Override
    public String getData(String request) {
        System.out.println("[BLogicBean] getData çağrıldı. Gelen istek: " + request);
        return "Response from BLogicBean";
    }
    
}