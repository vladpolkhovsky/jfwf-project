package by.bsu.jfwf.components;

import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.List;

public interface Component<T extends Renderable> {

    List<Component<Renderable>> getInnerComponents(SessionContext sessionContext);

    ContextResolver<T> getContextResolver();

    T calculateContent(SessionContext sessionContext);

}
