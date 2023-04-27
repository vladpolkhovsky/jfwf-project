package by.bsu.jfwf.resolver;

import by.bsu.jfwf.services.dispatcher.EventHandler;
import by.bsu.jfwf.session.SessionContext;

import java.util.Collections;

@FunctionalInterface
public interface ActionCallback {

    void callback(SessionContext sessionContext, EventHandler.EventRequest eventRequest);

    default void callback(SessionContext sessionContext) {
        callback(sessionContext, new EventHandler.EventRequest(Collections.emptyList()));
    }

}
