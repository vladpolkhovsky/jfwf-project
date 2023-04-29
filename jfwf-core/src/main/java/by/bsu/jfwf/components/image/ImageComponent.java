package by.bsu.jfwf.components.image;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.components.interactive.ButtonComponentBuilder;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;

import java.util.LinkedHashMap;

public class ImageComponent extends AbstractComponent<RenderableString> {

    private final String path;

    private final String width;

    private final String height;

    private final boolean isOrigSize;

    protected ImageComponent(LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent, String path, String width, String height, boolean isOrigSize) {
        super(resolverToComponent);
        this.path = path;
        this.width = width;
        this.height = height;
        this.isOrigSize = isOrigSize;
    }

    public String getPath() {
        return path;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public boolean isOrigSize() {
        return isOrigSize;
    }

    @Override
    public ContextResolver<RenderableString> getContextResolver() {
        return null;
    }

    public static ImageComponentBuilder builder() {
        return new ImageComponentBuilder();
    }

}
