package appA.event;


import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class AServiceEvent<T> extends ApplicationEvent {
    private static final Logger logger = LoggerFactory.getLogger(AServiceEvent.class);
    private final String methodName;
    private final Object[] params;
    private final CompletableFuture<T> responseFuture;


    public AServiceEvent(Object source, String methodName, Object... params) {
        super(source);
        this.methodName = methodName;
        this.params = params;
        this.responseFuture = new CompletableFuture<>();
        logger.info("[AServiceEvent] Event oluşturuldu: methodName={}, params={}", methodName, Arrays.toString(params));
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
