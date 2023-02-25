package by.bsu.jfwf.resolver.impl;

import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.Collection;
import java.util.function.Function;

public class ContextResolverImpl<ResolverFunctionResult> extends AbstractContextResolver<ResolverFunctionResult> {
    public ContextResolverImpl(Collection<String> dependedKeys, Function<SessionContext, ResolverFunctionResult> contextFunction) {
        super(dependedKeys, contextFunction);
    }

    public final static class ContextResolverBuilderImpl<ResolverFunctionResult, BuilderFunctionResult extends ContextResolver<ResolverFunctionResult>> extends AbstractContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult> {
        @Override
        public BuilderFunctionResult apply(Function<SessionContext, ResolverFunctionResult> resolverFunction) {
            return (BuilderFunctionResult) new ContextResolverImpl<>(dependedKeys, resolverFunction);
        }
    }

}
