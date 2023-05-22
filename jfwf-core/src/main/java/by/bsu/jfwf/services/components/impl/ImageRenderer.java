package by.bsu.jfwf.services.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.image.ImageComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class ImageRenderer extends AbstractComponentRenderer {

    public ImageRenderer(ITemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public String render(SessionContext sessionContext, Component<? extends Renderable> component) {

        ImageComponent imageComponent = (ImageComponent) component;

        Context myContext = new Context();
        myContext.setVariable("path", imageComponent.getPath());
        myContext.setVariable("customSize", imageComponent.isOrigSize());

        if (!imageComponent.isOrigSize()) {
            myContext.setVariable("height", imageComponent.getHeight());
            myContext.setVariable("width", imageComponent.getWidth());
        }

        return templateEngine.process("ImageComponent", myContext);
    }

    @Override
    public Class<? extends Component> renderedClass() {
        return ImageComponent.class;
    }

}
