package by.bsu.jfwf.controllers;

import by.bsu.jfwf.services.dispatcher.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/action/")
public class JfwfActionHandlerController {

    @Autowired
    private EventHandler eventHandler;

    @RequestMapping(value = "/stateless/{actionId}", method = RequestMethod.POST)
    public void handleAction(@PathVariable String actionId) {
        System.out.println(actionId);
        eventHandler.handle(actionId);
    }

    @RequestMapping(value = "/stateful/{actionId}", method = RequestMethod.POST)
    public void handleAction(@PathVariable String actionId, @RequestBody EventHandler.EventRequest event) {
        eventHandler.handle(actionId, event);
    }

}
