package by.bsu.jfwf.components.container;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractLayoutComponent extends AbstractComponent<Renderable> implements Component<Renderable> {

    private final ContentResolver<Renderable> contentResolver;

    protected AbstractLayoutComponent(ContentResolver<Renderable> contentResolver, LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent) {
        super(resolverToComponent);
        this.contentResolver = contentResolver;
    }

    @Override
    public List<Component<Renderable>> getInnerComponents(SessionContext sessionContext) {
        return getResolverToComponent().entrySet()
                .stream()
                .filter(entry -> entry.getKey().apply(sessionContext))
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    public ContextResolver<Renderable> getContextResolver() {
        return contentResolver;
    }

    @Override
    public Renderable calculateContent(SessionContext sessionContext) {
        return getContextResolver().getResolverFunction(sessionContext);
    }

}
