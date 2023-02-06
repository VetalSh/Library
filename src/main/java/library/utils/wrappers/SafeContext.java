package library.utils.wrappers;

import javax.servlet.ServletContext;

/**
 * Wrapper for Context {@link library.utils.wrappers.Safe}
 */
public class SafeContext extends Safe<Object> {
    private final ServletContext context;

    public SafeContext(ServletContext context) {
        this.context = context;
    }

    @Override
    public SafeContext get(String s) {
        value = context.getAttribute(s);
        setParam(s);
        return this;
    }
}
