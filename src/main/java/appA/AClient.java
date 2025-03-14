package appA;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import appA.proxybean.AProxyBean;

@Component
public class AClient implements CommandLineRunner {
    private final AProxyBean aProxyBean;

    public AClient(AProxyBean aProxyBean) {
        this.aProxyBean = aProxyBean;
    }

    @Override
    public void run(String... args) {
        System.out.println("[AClient] AService.processRequest çağrılıyor...");
        
        aProxyBean.callMethod("processRequest", "Merhaba, B!");
    }
}
