package by.bsu.jfwf.resolver.logic.impl;

import by.bsu.jfwf.resolver.impl.AbstractContextResolver;
import by.bsu.jfwf.resolver.impl.AbstractContextResolverBuilder;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.Collection;
import java.util.function.Function;

public class LogicalResolverImpl extends AbstractContextResolver<Boolean> implements LogicResolver {

    public LogicalResolverImpl(Collection<String> dependedKeys, Function<SessionContext, Boolean> contextFunction) {
        super(dependedKeys, contextFunction);
    }

    public static class LogicalResolverBuilderImpl extends AbstractContextResolverBuilder<Boolean, LogicResolver> {

        @Override
        public LogicResolver apply(Function<SessionContext, Boolean> resolverFunction) {
            return new LogicalResolverImpl(dependedKeys, resolverFunction);
        }

    }

}
