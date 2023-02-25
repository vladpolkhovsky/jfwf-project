package by.bsu.jfwf.resolver.impl;

import by.bsu.jfwf.session.SessionContext;
import by.bsu.jfwf.resolver.ContextResolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractContextResolver<ResolverFunctionResult> implements ContextResolver<ResolverFunctionResult> {

    private final List<String> dependedKeys;
    private final Function<SessionContext, ResolverFunctionResult> contextFunction;

    public AbstractContextResolver(Collection<String> dependedKeys, Function<SessionContext, ResolverFunctionResult> contextFunction) {
        this.dependedKeys = new ArrayList<>(dependedKeys);
        this.contextFunction = contextFunction;
    }

    @Override
    public List<String> getDependentKeys() {
        return dependedKeys;
    }

    @Override
    public Function<SessionContext, ResolverFunctionResult> getResolverFunction() {
        return contextFunction;
    }

}
