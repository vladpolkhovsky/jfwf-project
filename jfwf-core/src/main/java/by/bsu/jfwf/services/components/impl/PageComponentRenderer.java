package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.session.SessionContext;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Arrays;

@Service
public class PageComponentRenderer implements ComponentRenderer {

    private final ITemplateEngine templateEngine;

    public PageComponentRenderer(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {
        Context myContext = new Context();
        myContext.setVariable("tittle", "Hello world");
        myContext.setVariable("siblings", Arrays.asList("a", "b"));
        return templateEngine.process("SimplePage", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return PageComponent.class;
    }

    @PostConstruct
    void init() {
        String render = render(null, null);
        System.out.println(render);
    }
}
