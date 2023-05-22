package by.bsu.jfwf.components.impl;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.ComponentBuilder;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;

import java.util.LinkedHashMap;

public abstract class AbstractComponentBuilder<T extends Renderable> implements ComponentBuilder<T> {

    protected final LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent = new LinkedHashMap<>();

    protected ContentResolver<T> contentResolver;

    @Override
    public ComponentBuilder<T> contextResolver(ContentResolver<T> contentResolver) {
        this.contentResolver = contentResolver;
        return this;
    }

    @Override
    public ComponentBuilder<T> append(Component<? extends Renderable> component) {
        appendIf(LogicResolver.alwaysTrue(), component);
        return this;
    }

    @Override
    public ComponentBuilder<T> appendIf(LogicResolver statement, Component<? extends Renderable> component) {
        resolverToComponent.put(statement, (Component<Renderable>) component);
        return this;
    }

}
