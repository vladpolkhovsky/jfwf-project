package by.bsu.jfwf.render;

import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.session.SessionContext;

@FunctionalInterface
public interface Renderable {

    static ContentResolver<RenderableString> staticText(String text) {
        return ContentResolver.<RenderableString>create().apply(t -> new RenderableString(text));
    }

    static ContentResolver<RenderableString> text(ContextResolver<String> contextResolver) {
        return ContentResolver.<RenderableString>create()
                .var(contextResolver.getDependentKeys())
                .apply(t -> new RenderableString(contextResolver.getResolverFunction(t)));
    }

    String render(SessionContext sessionContext);

}
