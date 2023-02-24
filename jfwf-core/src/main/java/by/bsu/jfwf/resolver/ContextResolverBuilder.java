package by.bsu.jfwf.resolver;

import by.bsu.jfwf.session.SessionContext;

import java.util.Collection;
import java.util.function.Function;

public interface ContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult extends ContextResolver<ResolverFunctionResult>> {

    ContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult> var(String name);

    default ContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult> var(String... names) {
        for (String name : names) {
            var(name);
        }
        return this;
    }

    default ContextResolverBuilder<ResolverFunctionResult, BuilderFunctionResult> var(Collection<String> names) {
        for (String name : names) {
            var(name);
        }
        return this;
    }

    BuilderFunctionResult apply(Function<SessionContext, ResolverFunctionResult> resolverFunction);

}
