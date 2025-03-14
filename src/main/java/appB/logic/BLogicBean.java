package appB.logic;
import java.lang.reflect.Method;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import appB.event.BServiceEvent;
import appB.idl.BServiceOperations;

@Service
public class BLogicBean implements BServiceOperations {
    @Override
    public String getData(String request) {
        System.out.println("[BLogicBean] B isteği aldı: " + request);
        return "BLogicBean'den cevap";
    }

    @EventListener
    public void handleBRequest(BServiceEvent event) {
        System.out.println("[BLogicBean] B'den gelen istek işleniyor: " + event.getMethodName());

        try {
            Method method = this.getClass().getMethod(event.getMethodName(), String.class);
            Object result = method.invoke(this, event.getParams());
            System.out.println("Method executed successfully, result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
