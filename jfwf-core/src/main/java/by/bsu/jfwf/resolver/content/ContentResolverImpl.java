package by.bsu.jfwf.resolver.content;

import by.bsu.jfwf.resolver.impl.AbstractContextResolver;
import by.bsu.jfwf.session.SessionContext;
import by.bsu.jfwf.render.Renderable;

import java.util.Collection;
import java.util.function.Function;

public class ContentResolverImpl<T extends Renderable> extends AbstractContextResolver<T> implements ContentResolver<T> {

    public ContentResolverImpl(Collection<String> dependedKeys, Function<SessionContext, T> contextFunction) {
        super(dependedKeys, contextFunction);
    }

}
