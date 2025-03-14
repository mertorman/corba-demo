package appB.event;

import org.springframework.context.ApplicationEvent;

public class BServiceEvent extends ApplicationEvent {
    private final String methodName;
    private final Object[] params;

    public BServiceEvent(Object source, String methodName, Object... params) {
        super(source);
        this.methodName = methodName;
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }
}
