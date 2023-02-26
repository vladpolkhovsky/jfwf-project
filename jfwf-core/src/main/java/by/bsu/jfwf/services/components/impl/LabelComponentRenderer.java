package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.text.LabelComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;

@Service
public class LabelComponentRenderer implements ComponentRenderer {

    private final ITemplateEngine templateEngine;

    public LabelComponentRenderer(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {

        return null;
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return LabelComponent.class;
    }

}
