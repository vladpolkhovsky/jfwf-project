package by.bsu.jfwf.components.image;

import by.bsu.jfwf.components.impl.AbstractComponentBuilder;
import by.bsu.jfwf.render.impl.RenderableString;

public class ImageComponentBuilder extends AbstractComponentBuilder<RenderableString> {

    private String path;

    private String width, height;

    boolean isOrigSize = true;

    public ImageComponentBuilder path(String path) {
        this.path = path;
        return this;
    }

    public ImageComponentBuilder size(String widthPx, String heightPx) {
        this.isOrigSize = false;
        this.width = widthPx;
        this.height = heightPx;
        return this;
    }

    @Override
    public ImageComponent build() {
        return new ImageComponent(resolverToComponent, path, width, height, isOrigSize);
    }

}
