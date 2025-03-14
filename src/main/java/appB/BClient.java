package appB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import appB.proxy.BProxyBean;

@Component
public class BClient implements CommandLineRunner {
    private final BProxyBean proxy;

    @Autowired
    public BClient(BProxyBean proxy) {
        this.proxy = proxy;
    }

    @Override
    public void run(String... args) {
        System.out.println("[BClient] BLogicBean'e istek gönderiliyor...");
        proxy.callMethod("getData", "Merhaba, A!");
    }
}
