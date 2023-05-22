package by.bsu.jfwf.render.impl;

import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class RenderableString implements Renderable {

    private final ContextResolver<String> stringContentResolver;

    public RenderableString(ContextResolver<String> stringContentResolver) {
        this.stringContentResolver = stringContentResolver;
    }
    public RenderableString(String text) {
        this.stringContentResolver = new StaticTextContextResolver(text);
    }
    public ContextResolver<String> getStringContextResolver() {
        return stringContentResolver;
    }
    @Override
    public String render(SessionContext sessionContext) {
        return stringContentResolver.getResolverFunction(sessionContext);
    }
    private static final class StaticTextContextResolver implements ContextResolver<String> {

        private final String text;

        private StaticTextContextResolver(String text) {
            this.text = text;
        }
        @Override
        public List<String> getDependentKeys() {
            return Collections.emptyList();
        }
        @Override
        public Function<SessionContext, String> getResolverFunction() {
            return t -> text;
        }
    }
}
