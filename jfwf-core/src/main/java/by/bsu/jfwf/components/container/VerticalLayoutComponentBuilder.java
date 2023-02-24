package by.bsu.jfwf.components.container;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;

public class VerticalLayoutComponentBuilder extends AbstractLayoutComponentBuilder {

    @Override
    public Component<Renderable> build() {
        return new VerticalLayoutComponent(contentResolver, resolverToComponent);
    }

}
