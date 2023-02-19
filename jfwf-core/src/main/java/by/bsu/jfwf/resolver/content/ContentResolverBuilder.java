package by.bsu.jfwf.resolver.content;

import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.ContextResolverBuilder;

public interface ContentResolverBuilder<T extends Renderable> extends ContextResolverBuilder<T, ContextResolver<T>> {

}
