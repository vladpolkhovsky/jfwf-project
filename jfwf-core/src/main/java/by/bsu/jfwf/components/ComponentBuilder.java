package by.bsu.jfwf.components;

import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;

public interface ComponentBuilder<T extends Renderable> {

    ComponentBuilder<T> contextResolver(ContentResolver<T> contentResolver);

    ComponentBuilder<T> append(Component<? extends Renderable> component);

    ComponentBuilder<T> appendIf(LogicResolver statement, Component<? extends Renderable> component);

    Component<T> build();

}
