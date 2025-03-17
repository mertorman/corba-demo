package appB.event;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class BServiceEvent extends ApplicationEvent {
    private static final Logger logger = LoggerFactory.getLogger(BServiceEvent.class);
    private final String methodName;
    private final Object[] params;

    public BServiceEvent(Object source, String methodName, Object... params) {
        super(source);
        this.methodName = methodName;
        this.params = params;
        logger.info("[BServiceEvent] Event oluşturuldu: methodName={}, params={}", methodName, Arrays.toString(params));
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }
}
