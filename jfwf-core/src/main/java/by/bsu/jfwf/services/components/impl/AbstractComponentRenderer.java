package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.thymeleaf.ITemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractComponentRenderer implements ComponentRenderer {

    protected final ITemplateEngine templateEngine;

    protected List<ComponentRenderer> componentRenderers = Collections.emptyList();

    private ErrorRenderer errorRenderer = null;

    protected AbstractComponentRenderer(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        errorRenderer = new ErrorRenderer(templateEngine);
    }

    @Lazy
    @Autowired
    public void setComponentRenderers(@Qualifier("componentRenderers") List<ComponentRenderer> componentRenderers) {
        this.componentRenderers = componentRenderers;
    }

    public List<String> renderSiblings(SessionContext sessionContext, List<Component<Renderable>> innerComponents) {
        List<String> list = new ArrayList<>();

        for (Component<Renderable> innerComponent : innerComponents) {
            Optional<ComponentRenderer> any = componentRenderers.stream()
                .filter(componentRenderer -> componentRenderer.renderedClass().equals(innerComponent.getClass()))
                .findAny();
            String render = any.orElse(errorRenderer).render(sessionContext, innerComponent);
            list.add(render);
        }

        return list;
    }

}
