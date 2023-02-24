package by.bsu.jfwf.components.page;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.LinkedHashMap;
import java.util.List;

public class PageComponent<T extends RenderableString> extends AbstractComponent<T> implements Component<T> {

    private final ContentResolver<T> tittleContentResolver;

    protected PageComponent(ContentResolver<T> tittleContentResolver,
                            LinkedHashMap<LogicResolver, Component<Renderable>> resolverToComponent) {
        super(resolverToComponent);
        this.tittleContentResolver = tittleContentResolver;
    }

    public static <T extends RenderableString> PageComponentBuilder<T> builder() {
        return new PageComponentBuilder<>();
    }

    @Override
    public List<Component<Renderable>> getInnerComponents(SessionContext sessionContext) {
        return null;
    }

    @Override
    public ContextResolver<T> getContextResolver() {
        return tittleContentResolver;
    }

    @Override
    public T calculateContent(SessionContext sessionContext) {
        return getContextResolver().getResolverFunction(sessionContext);
    }

}
