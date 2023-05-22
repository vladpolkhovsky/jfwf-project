package by.bsu.jfwf.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractComponent<T extends Renderable> implements Component<T> {

    private final LinkedHashMap<LogicResolver, Component<Renderable>> logicResolverToComponent;

    protected AbstractComponent(LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent) {
        this.logicResolverToComponent = resolverToComponent;
    }

    public LinkedHashMap<LogicResolver, Component<Renderable>> getLogicResolverToComponent() {
        return logicResolverToComponent;
    }

    @Override
    public List<Component<Renderable>> getInnerComponents(SessionContext sessionContext) {
        return getLogicResolverToComponent().entrySet()
            .stream()
            .filter(entry -> entry.getKey().apply(sessionContext))
            .map(Map.Entry::getValue)
            .toList();
    }

    @Override
    public T calculateContent(SessionContext sessionContext) {
        return getContextResolver().getResolverFunction(sessionContext);
    }
}
