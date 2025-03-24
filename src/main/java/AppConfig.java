import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//AppConfig Sınıfı (Configuration ve Component Scan ile Otomatik Bean Yönetimi) işini üstlenir.
@Configuration
//ComponentScan anotasyonu ile belirtilen paketleri tarar ve o paket 
//içindeki @Component, @Service, @Repository ve @Controller gibi anotasyonları taşıyan sınıfları otomatik olarak Spring konteynerine dahil eder.
@ComponentScan(basePackages = {"appA","appB"}) // Burada basePackages parametresiyle appA ve appB klasörü içerisini tara demiş olduk.
public class AppConfig {
    // Spring'in otomatik olarak taradığı ve kaydettiği bileşenler burada bulunur.
}
