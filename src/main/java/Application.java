import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import appA.AClient;

public class Application {
    //buradan run edip çalıştırabilirsiniz.
    public static void main(String[] args) {
        // AppConfig sınıfı ile Spring Context başlatılır
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // AClient bean'ini alıp çalıştırıyoruz
        AClient aClient = context.getBean(AClient.class);
        aClient.run(args); // Burada AClient içindeki kodlar çalışacak
    }
}