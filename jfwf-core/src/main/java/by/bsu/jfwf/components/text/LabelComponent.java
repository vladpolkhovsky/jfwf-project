package by.bsu.jfwf.components.text;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.List;

public class LabelComponent<T extends Renderable> implements Component<T> {

    @Override
    public List<Component<Renderable>> getInnerComponents(SessionContext sessionContext) {
        return null;
    }

    @Override
    public ContextResolver<T> getContextResolver() {
        return null;
    }

    @Override
    public T calculateContent(SessionContext sessionContext) {
        return null;
    }
}
