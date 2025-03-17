package appB.logic;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import appB.event.BServiceEvent;
import appB.idl.BServiceOperations;

@Service
public class BLogicBean implements BServiceOperations {
    private static final Logger logger = LoggerFactory.getLogger(BLogicBean.class);

    @Override
    public String getData(String request) {
        logger.info("[BLogicBean] B isteği aldı.");
        return "BLogicBean'den cevap";
    }

    @EventListener
    public void handleBRequest(BServiceEvent event) {
        logger.info("[BLogicBean] Event alındı: {}", event.getMethodName());

        try {
            Method method = this.getClass().getMethod(event.getMethodName(), String.class);
            logger.info("[BLogicBean] Metot çalıştırılıyor: {}", method.getName());

            Object result = method.invoke(this, event.getParams());

            logger.info("[BLogicBean] Metot başarıyla çalıştırıldı, sonuç: {}", result);
        } catch (Exception e) {
            logger.error("[BLogicBean] Hata oluştu: {}", e.getMessage(), e);
        }
    }
}

