package by.bsu.jfwf.resolver.content;

import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;

public interface ContentResolver<T extends Renderable> extends ContextResolver<T> {

    static <T extends Renderable> ContentResolverBuilder<T> create() {
        return new ContentResolverBuilderImpl<>();
    }

}
