package by.bsu.jfwf.components.container;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;

import java.util.LinkedHashMap;

public class VerticalLayoutComponent extends AbstractLayoutComponent {

    protected VerticalLayoutComponent(ContentResolver<Renderable> contentResolver, LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent) {
        super(contentResolver, resolverToComponent);
    }

    public static VerticalLayoutComponentBuilder builder() {
        return new VerticalLayoutComponentBuilder();
    }

}
