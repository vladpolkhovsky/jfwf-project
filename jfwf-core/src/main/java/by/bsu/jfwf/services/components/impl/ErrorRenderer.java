package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.session.SessionContext;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

public class ErrorRenderer implements ComponentRenderer {

    private final ITemplateEngine templateEngine;

    public ErrorRenderer(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        Context myContext = new Context();
        myContext.setVariable("className", component.getClass());
        return templateEngine.process("ErrorOnRendering", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return null;
    }

}
