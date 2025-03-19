package appA;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import appA.proxybean.AProxyBean;

@Component
public class AClient implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AClient.class);
    private final AProxyBean aProxyBean;

    public AClient(AProxyBean aProxyBean) {
        this.aProxyBean = aProxyBean;
    }

    @Override
    public void run(String... args) {
        logger.info("[AClient] AService.processRequest çağrılıyor...");

        String message = "Hello from AClient!";
        logger.info("[AClient] Gönderilen mesaj: {}", message);

        CompletableFuture<Object> futureResult = aProxyBean.callMethod("processRequest", message);
        futureResult.thenAccept(result -> {
            logger.info("processRequest sonucu: " + result);
        });
    }
}
