package by.bsu.jfwf.components.page;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.impl.AbstractComponentBuilder;
import by.bsu.jfwf.render.impl.RenderableString;

public class PageComponentBuilder<T extends RenderableString> extends AbstractComponentBuilder<T> {

    @Override
    public Component<T> build() {
        return new PageComponent<>(contentResolver, resolverToComponent);
    }

}
