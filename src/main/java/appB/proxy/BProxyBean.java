package appB.proxy;

import appB.event.BServiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BProxyBean {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public BProxyBean(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void callMethod(String methodName, Object... params) {
        eventPublisher.publishEvent(new BServiceEvent(this, methodName, params));
    }
}
