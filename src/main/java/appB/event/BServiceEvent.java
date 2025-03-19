package appB.event;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class BServiceEvent<T> extends ApplicationEvent {
    private static final Logger logger = LoggerFactory.getLogger(BServiceEvent.class);
    private final String methodName;
    private final Object[] params;
    private final CompletableFuture<T> responseFuture;

    public BServiceEvent(Object source, String methodName, Object... params) {
        super(source);
        this.methodName = methodName;
        this.params = params;
        this.responseFuture = new CompletableFuture<>();
        logger.info("[BServiceEvent] Event oluşturuldu: methodName={}, params={}", methodName, Arrays.toString(params));
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }
    
    public CompletableFuture<T> getResponseFuture() {
        return responseFuture;
    }
}
