package appA.logicbean;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import appA.event.AServiceEvent;
import appA.idl.AServiceOperations;
import appB.proxy.BProxyBean;


@Service
public class ALogicBean implements AServiceOperations {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public ALogicBean(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public String processRequest(String request) {
        System.out.println("[ALogicBean] processRequest çalıştırıldı: " + request);
        
        // BProxyBean'daki callMethod çağırarak event publish eder ve B'nin metodunu çalıştırır.
        BProxyBean bProxyBean = new BProxyBean(eventPublisher);
        bProxyBean.callMethod("getData", request);

        return "AService: processRequest çalıştırıldı -> " + request;
    }

    @EventListener
    public void handleARequest(AServiceEvent event) {
        System.out.println("[ALogicBean] A'dan gelen istek işleniyor: " + event.getMethodName());

        try {
            Method method = this.getClass().getMethod(event.getMethodName(), String.class);
            Object result = method.invoke(this, event.getParams());
            System.out.println("Method executed successfully, result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
