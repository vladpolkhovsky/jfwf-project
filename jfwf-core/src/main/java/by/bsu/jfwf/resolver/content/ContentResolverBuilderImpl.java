package by.bsu.jfwf.resolver.content;

import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.AbstractContextResolverBuilder;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.function.Function;

public class ContentResolverBuilderImpl<T extends Renderable>
        extends AbstractContextResolverBuilder<T, ContextResolver<T>>
        implements ContentResolverBuilder<T> {
    @Override
    public ContextResolver<T> apply(Function<SessionContext, T> resolverFunction) {
        return new ContentResolverImpl<T>(dependedKeys, resolverFunction);
    }
}
