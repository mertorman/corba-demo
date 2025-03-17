package appB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import appB.proxy.BProxyBean;

/* 
@Component
public class BClient implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(BClient.class);
    private final BProxyBean proxy;

    @Autowired
    public BClient(BProxyBean proxy) {
        this.proxy = proxy;
    }

    @Override
    public void run(String... args) {
        logger.info("[BClient] BLogicBean'e istek gönderiliyor...");
        
        String message = "Hello from BClient!";
        logger.info("[BClient] Gönderilen mesaj: {}", message);

        proxy.callMethod("getData", message);
    }
}*/