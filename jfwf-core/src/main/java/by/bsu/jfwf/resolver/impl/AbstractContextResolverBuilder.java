package by.bsu.jfwf.resolver.impl;

import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.ContextResolverBuilder;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult extends ContextResolver<ResolverFunctionResult>>
    implements ContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult> {
    protected final Set<String> dependedKeys = new HashSet<>();

    @Override
    public ContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult> var(String name) {
        dependedKeys.add(name);
        return this;
    }

}
