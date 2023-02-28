package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.session.SessionContext;
import org.thymeleaf.ITemplateEngine;

import java.util.List;
import java.util.Objects;

public abstract class AbstractComponentRenderer implements ComponentRenderer {

    protected final ITemplateEngine templateEngine;

    protected final List<ComponentRenderer> componentRenderers;

    protected AbstractComponentRenderer(ITemplateEngine templateEngine, List<ComponentRenderer> componentRenderers) {
        this.templateEngine = templateEngine;
        this.componentRenderers = componentRenderers;
    }

    public List<String> renderSiblings(SessionContext sessionContext, List<Component<Renderable>> innerComponents) {
        return innerComponents.stream()
                .map(ic -> componentRenderers.stream()
                        .filter(cr -> Objects.equals(cr.renderedClass(), ic.getClass()))
                        .findAny().orElseThrow()
                        .render(sessionContext, ic))
                .toList();
    }

}
