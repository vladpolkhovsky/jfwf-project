package by.bsu.jfwf.render;

import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.session.SessionContext;

@FunctionalInterface
public interface Renderable {

    static ContentResolver<RenderableString> staticText(String text) {
        return ContentResolver.<RenderableString>create().apply(t -> new RenderableString(text));
    }

    String render(SessionContext sessionContext);

}
