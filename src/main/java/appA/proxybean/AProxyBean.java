package appA.proxybean;

import appA.event.AServiceEvent;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AProxyBean {
    private static final Logger logger = LoggerFactory.getLogger(AProxyBean.class);
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public AProxyBean(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public CompletableFuture<Object> callMethod(String methodName, Object... params) {
    logger.info("[AProxyBean] Event tetikleniyor: {}", methodName);

    AServiceEvent<Object> event = new AServiceEvent<>(this, methodName, params);
    eventPublisher.publishEvent(event);

    logger.info("[AProxyBean] Event başarıyla yayınlandı: {}", methodName);

    return event.getResponseFuture();
}

}
