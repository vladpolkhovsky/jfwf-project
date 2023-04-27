package by.bsu.jfwf.session.impl;

import by.bsu.jfwf.session.SessionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionContextImpl implements SessionContext {

    private final Map<String, Object> nameToObject = new HashMap<>();
    private final Map<String, Boolean> nameToChanged = new HashMap<>();

    @Override
    public <T> T get(String name) {
        return (T) nameToObject.get(name);
    }

    @Override
    public <T> void set(String name, T value) {
        nameToObject.put(name, value);
    }

    @Override
    public void setChanged(String name) {
        nameToChanged.put(name, true);
    }

    @Override
    public boolean isChanged(String name) {
        return nameToChanged.getOrDefault(name, false);
    }
}
