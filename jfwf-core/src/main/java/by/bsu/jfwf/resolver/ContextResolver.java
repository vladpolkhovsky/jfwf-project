package by.bsu.jfwf.resolver;

import by.bsu.jfwf.resolver.impl.ContextResolverImpl;
import by.bsu.jfwf.session.SessionContext;

import java.util.List;
import java.util.function.Function;

public interface ContextResolver<ResolverFunctionResult> {
    static <ResolverFunctionResult> ContextResolverBuilder<ResolverFunctionResult, ContextResolver<ResolverFunctionResult>> builder() {
        return new ContextResolverImpl.ContextResolverBuilderImpl<>();
    }
    List<String> getDependentKeys();
    Function<SessionContext, ResolverFunctionResult> getResolverFunction();
    default ResolverFunctionResult getResolverFunction(SessionContext sessionContext) {
        return getResolverFunction().apply(sessionContext);
    }
}
