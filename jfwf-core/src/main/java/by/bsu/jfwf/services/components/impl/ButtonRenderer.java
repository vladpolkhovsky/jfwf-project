package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.interactive.ButtonComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class ButtonRenderer extends AbstractComponentRenderer {

    public ButtonRenderer(ITemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        Renderable renderable = component.calculateContent(sessionContext);
        String name = renderable.render(sessionContext);

        String actionId = ((ButtonComponent) component).getActionId();

        Context myContext = new Context();
        myContext.setVariable("id", actionId);
        myContext.setVariable("name", name);

        return templateEngine.process("Button", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return ButtonComponent.class;
    }
}
