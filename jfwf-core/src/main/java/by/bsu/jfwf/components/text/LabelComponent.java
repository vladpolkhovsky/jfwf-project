package by.bsu.jfwf.components.text;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.session.SessionContext;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class LabelComponent<T extends Renderable> extends AbstractComponent<T> implements Component<T> {

    private final ContentResolver<T> contentResolver;

    protected LabelComponent(ContentResolver<T> contentResolver) {
        super(new LinkedHashMap<>());
        this.contentResolver = contentResolver;
    }

    public static <T extends Renderable> LabelComponent<T> build(ContentResolver<T> contentResolver) {
        return new LabelComponent<>(contentResolver);
    }

    @Override
    public List<Component<Renderable>> getInnerComponents(SessionContext sessionContext) {
        return Collections.emptyList();
    }

    @Override
    public ContextResolver<T> getContextResolver() {
        return contentResolver;
    }

}
