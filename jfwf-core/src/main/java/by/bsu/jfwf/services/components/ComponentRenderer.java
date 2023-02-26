package by.bsu.jfwf.services.components;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.session.SessionContext;

public interface ComponentRenderer {

    String render(SessionContext sessionContext, Component<? extends Renderable> component);

    Class<? extends Component> renderedClass();

}
