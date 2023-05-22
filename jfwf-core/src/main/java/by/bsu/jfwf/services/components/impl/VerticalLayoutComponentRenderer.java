package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.container.VerticalLayoutComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service
public class VerticalLayoutComponentRenderer extends AbstractComponentRenderer {
    protected VerticalLayoutComponentRenderer(ITemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        List<Component<Renderable>> innerComponents = component.getInnerComponents(sessionContext);
        List<String> siblings = renderSiblings(sessionContext, innerComponents);

        Context myContext = new Context();
        myContext.setVariable("siblings", siblings);
        return templateEngine.process("SimpleVerticalLayout", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return VerticalLayoutComponent.class;
    }
}
