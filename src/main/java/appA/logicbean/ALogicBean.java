package appA.logicbean;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import appA.event.AServiceEvent;
import appA.idl.AServiceOperations;
import appB.proxy.BProxyBean;


@Service
public class ALogicBean implements AServiceOperations {
    private static final Logger logger = LoggerFactory.getLogger(ALogicBean.class);
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public ALogicBean(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public String processRequest(String request) {
        logger.info("[ALogicBean] processRequest çalıştırıldı.");

        // BProxyBean'daki callMethod çağırarak event publish eder ve B'nin metodunu çalıştırır.
        BProxyBean bProxyBean = new BProxyBean(eventPublisher);
        logger.info("[ALogicBean] BService'e event gönderiliyor...");

        CompletableFuture<Object> futureResult = bProxyBean.callMethod("getData", request);
        
        try {
            // Sonucu bekleyerek al
            Object result = futureResult.get(); // .join() da kullanılabilir
    
            logger.info("getData sonucu: " + result);
            
            return "AService: processRequest çalıştırıldı -> " + request + " | Sonuç: " + result;
        } catch (InterruptedException | ExecutionException e) {
            logger.error("processRequest sırasında hata oluştu!", e);
            return "AService: processRequest başarısız!";
        }
    }

    @EventListener
    public void handleARequest(AServiceEvent<Object> event) {
        logger.info("[ALogicBean] Event alındı: {}", event.getMethodName());

        try {
            Method method = this.getClass().getMethod(event.getMethodName(), String.class);
            logger.info("[ALogicBean] Metot çalıştırılıyor: {}", method.getName());

            Object result = method.invoke(this, event.getParams());

            // Sonucu CompletableFuture üzerinden geri döndür
            event.getResponseFuture().complete(result);

            //logger.info("[ALogicBean] Metot başarıyla çalıştırıldı, sonuç: {}", result);
        } catch (Exception e) {
            logger.error("[ALogicBean] Hata oluştu: {}", e.getMessage(), e);
        }
    }
}

