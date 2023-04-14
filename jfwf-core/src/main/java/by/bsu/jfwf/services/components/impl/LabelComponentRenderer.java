package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.text.LabelComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service
public class LabelComponentRenderer extends AbstractComponentRenderer {

    public LabelComponentRenderer(ITemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public String render(SessionContext sessionContext,
                         Component<? extends Renderable> component) {
        List<Component<Renderable>> innerComponents = component
            .getInnerComponents(sessionContext);
        List<String> siblings = renderSiblings(sessionContext, innerComponents);

        if (!siblings.isEmpty()) {
            System.err.println("Siblings not null in LabelComponent");
        }

        Renderable renderable = component.calculateContent(sessionContext);
        String text = renderable.render(sessionContext);

        Context myContext = new Context();
        myContext.setVariable("text", text);

        return templateEngine.process("SimpleLabel", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return LabelComponent.class;
    }
}
