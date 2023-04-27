package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.interactive.TextAreaComponent;
import by.bsu.jfwf.components.interactive.TextFieldComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class TextAreaRenderer extends AbstractComponentRenderer {

    public TextAreaRenderer(ITemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        Renderable renderable = component.calculateContent(sessionContext);
        String name = renderable.render(sessionContext);

        String actionId = ((TextAreaComponent) component).getActionId();
        String keyValue = ((TextAreaComponent) component).getValueKeyName();
        String value = sessionContext.getOrDefault(keyValue, "");
        String realHeight = sessionContext.getOrDefault(actionId + "-height", "100");

        Context myContext = new Context();
        myContext.setVariable("id", actionId);
        myContext.setVariable("name", name);
        myContext.setVariable("keyValue", keyValue);
        myContext.setVariable("value", value);
        myContext.setVariable("height", realHeight);

        return templateEngine.process("TextArea", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return TextAreaComponent.class;
    }

}
