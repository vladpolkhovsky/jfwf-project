package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service
public class PageComponentRenderer extends AbstractComponentRenderer {

    public PageComponentRenderer(ITemplateEngine templateEngine, @Lazy List<ComponentRenderer> componentRenderers) {
        super(templateEngine, componentRenderers);
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        List<Component<Renderable>> innerComponents = component.getInnerComponents(sessionContext);
        List<String> siblings = renderSiblings(sessionContext, innerComponents);

        Renderable renderable = component.calculateContent(sessionContext);
        String tittle = renderable.render(sessionContext);

        Context myContext = new Context();
        myContext.setVariable("tittle", tittle);
        myContext.setVariable("siblings", siblings);

        return templateEngine.process("SimplePage", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return PageComponent.class;
    }

}
