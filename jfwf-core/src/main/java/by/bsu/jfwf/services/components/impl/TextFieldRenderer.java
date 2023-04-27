package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.interactive.TextFieldComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class TextFieldRenderer extends AbstractComponentRenderer {

    public TextFieldRenderer(ITemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        Renderable renderable = component.calculateContent(sessionContext);
        String name = renderable.render(sessionContext);

        String actionId = ((TextFieldComponent) component).getActionId();
        String keyValue = ((TextFieldComponent) component).getValueKeyName();
        String value = sessionContext.getOrDefault(keyValue, "");

        Context myContext = new Context();
        myContext.setVariable("id", actionId);
        myContext.setVariable("name", name);
        myContext.setVariable("keyValue", keyValue);
        myContext.setVariable("value", value);

        return templateEngine.process("TextField", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return TextFieldComponent.class;
    }

}
