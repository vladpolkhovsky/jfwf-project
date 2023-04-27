package by.bsu.jfwf.services.dispatcher.impl;

import by.bsu.jfwf.resolver.ActionCallback;
import by.bsu.jfwf.services.dispatcher.EventHandler;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventHandlerImpl implements EventHandler {

    private static Map<String, ActionCallback> actionIdToActionHandler = new HashMap<>();

    @Autowired
    private SessionContext sessionContext;

    @Override
    public void handle(String actionId) {
        ActionCallback actionCallback = actionIdToActionHandler.get(actionId);
        if (actionCallback == null) {
            System.out.println("No callback for " + actionId);
        } else {
            actionCallback.callback(sessionContext);
        }
    }

    @Override
    public void handle(String actionId, EventRequest eventRequest) {
        eventRequest.events().forEach(event -> {
            sessionContext.set(event.fieldName(), event.fieldValue());
        });
        ActionCallback actionCallback = actionIdToActionHandler.get(actionId);
        if (actionCallback == null) {
            System.out.println("No callback for " + actionId);
        } else {
            actionCallback.callback(sessionContext);
        }
    }

    public static void set(String actionId, ActionCallback actionCallback) {
        actionIdToActionHandler.put(actionId, actionCallback);
    }
}
