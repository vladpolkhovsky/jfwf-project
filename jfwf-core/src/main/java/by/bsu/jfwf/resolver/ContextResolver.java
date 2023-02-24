package by.bsu.jfwf.resolver;

import by.bsu.jfwf.session.SessionContext;

import java.util.List;
import java.util.function.Function;

public interface ContextResolver<ResolverFunctionResult> {

    List<String> getDependentKeys();

    Function<SessionContext, ResolverFunctionResult> getResolverFunction();

    default ResolverFunctionResult getResolverFunction(SessionContext sessionContext) {
        return getResolverFunction().apply(sessionContext);
    }

}
