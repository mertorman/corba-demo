package appA.proxybean;

import appA.event.AServiceEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AProxyBean {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public AProxyBean(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void callMethod(String methodName, Object... params) {
        eventPublisher.publishEvent(new AServiceEvent(this, methodName, params));
    }
}
