package by.bsu.jfwf.session.impl;

import by.bsu.jfwf.session.SessionContext;

import java.util.HashMap;
import java.util.Map;

public class SessionContextImpl implements SessionContext {

    private static Map<String, Object> nameToObject = new HashMap<>();

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

    }
}
