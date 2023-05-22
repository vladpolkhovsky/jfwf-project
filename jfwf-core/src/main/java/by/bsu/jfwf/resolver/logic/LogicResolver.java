package by.bsu.jfwf.resolver.logic;

import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.logic.impl.LogicalResolverImpl;
import by.bsu.jfwf.session.SessionContext;

import java.util.Collections;
import java.util.function.Function;

public interface LogicResolver extends ContextResolver<Boolean>, Function<SessionContext, Boolean> {
    static LogicalResolverImpl.LogicalResolverBuilderImpl create() {
        return new LogicalResolverImpl.LogicalResolverBuilderImpl();
    }
    static LogicResolver alwaysTrue() {
        return new LogicalResolverImpl(Collections.emptyList(), (t) -> Boolean.TRUE);
    }
    static LogicResolver alwaysFalse() {
        return new LogicalResolverImpl(Collections.emptyList(), (t) -> Boolean.FALSE);
    }
    @Override
    default Boolean apply(SessionContext sessionContext) {
        return getResolverFunction(sessionContext);
    }
}
