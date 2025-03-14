package appA.logicbean;

import appA.idl.AServicePOA;
import appB.proxy.BProxyBean;

public class ALogicBean extends AServicePOA {
    private BProxyBean bProxy;

    public ALogicBean(BProxyBean bProxy) {
        this.bProxy = bProxy;
        System.out.println("[ALogicBean] ALogicBean oluşturuldu.");
    }

    @Override
    public String processRequest(String request) {
        System.out.println("[ALogicBean] processRequest çağrıldı. Gelen istek: " + request);

        System.out.println("[ALogicBean] B'ye istek gönderiliyor...");
        String bResponse = bProxy.getData("Request from ALogicBean");

        String response = "A Response (including B's response): " + bResponse;
        System.out.println("[ALogicBean] Yanıt oluşturuldu: " + response);
        return response;
    }
}
