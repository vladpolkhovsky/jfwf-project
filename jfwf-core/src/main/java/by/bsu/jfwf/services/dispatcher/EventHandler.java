package by.bsu.jfwf.services.dispatcher;

import java.util.List;

public interface EventHandler {

    void handle(String actionId);

    void handle(String actionID, EventRequest eventRequest);

    record EventValue(String fieldName, String fieldValue) {

    }

    record EventRequest(List<EventValue> events) {

    }

}
