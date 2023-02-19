package by.bsu.jfwf.components.container;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractLayoutComponent implements Component<Renderable> {

    private final ContextResolver<Renderable> contentResolver;

    private final LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent;

    protected AbstractLayoutComponent(ContextResolver<Renderable> contentResolver, LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent) {
        this.contentResolver = contentResolver;
        this.resolverToComponent = resolverToComponent;
    }

    @Override
    public List<Component<Renderable>> getInnerComponents(SessionContext sessionContext) {
        return resolverToComponent.entrySet().stream()
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
        return getContextResolver().getResolverFunction().apply(sessionContext);
    }

}
