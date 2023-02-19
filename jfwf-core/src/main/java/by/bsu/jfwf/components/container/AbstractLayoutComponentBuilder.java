package by.bsu.jfwf.components.container;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.ComponentBuilder;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;

import java.util.LinkedHashMap;

public abstract class AbstractLayoutComponentBuilder implements ComponentBuilder<Renderable> {

    private final LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent = new LinkedHashMap<>();

    private ContextResolver<Renderable> contentResolver;

    @Override
    public ComponentBuilder<Renderable> contextResolver(ContextResolver<Renderable> contentResolver) {
        this.contentResolver = contentResolver;
        return this;
    }

    @Override
    public ComponentBuilder<Renderable> append(Component<? extends Renderable> component) {
        appendIf(LogicResolver.alwaysTrue(), component);
        return this;
    }

    @Override
    public ComponentBuilder<Renderable> appendIf(LogicResolver statement, Component<? extends Renderable> component) {
        resolverToComponent.put(statement, (Component<Renderable>) component);
        return this;
    }

    @Override
    public Component<Renderable> build() {
        return new VerticalLayoutComponent(contentResolver, resolverToComponent);
    }

}
