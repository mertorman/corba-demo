package appB.proxy;

import appB.event.BServiceEvent;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BProxyBean {
    private static final Logger logger = LoggerFactory.getLogger(BProxyBean.class);
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public BProxyBean(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void callMethod(String methodName, Object... params) {
        logger.info("[BProxyBean] Event tetikleniyor: {}", methodName);

        eventPublisher.publishEvent(new BServiceEvent(this, methodName, params));

        logger.info("[BProxyBean] Event başarıyla yayınlandı: {}", methodName);
    }
}
