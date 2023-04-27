package by.bsu.jfwf.components.interactive;

import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.services.dispatcher.impl.EventHandlerImpl;

import java.util.LinkedHashMap;
import java.util.UUID;

public class TextAreaComponent extends AbstractComponent<RenderableString> {

    private final String actionId;

    private final String valueKeyName;

    private final ContentResolver<RenderableString> renderableString;

    protected TextAreaComponent(ContentResolver<RenderableString> renderableString, ActionCallback actionCallback, String valueKeyName) {
        super(new LinkedHashMap<>());
        this.renderableString = renderableString;
        this.actionId = UUID.randomUUID().toString();
        this.valueKeyName = valueKeyName;
        EventHandlerImpl.set(actionId, actionCallback);
    }

    public String getActionId() {
        return actionId;
    }

    public String getValueKeyName() {
        return valueKeyName;
    }

    public static TextAreaComponentBuilder<RenderableString> builder() {
        return new TextAreaComponentBuilder<>();
    }

    @Override
    public ContextResolver<RenderableString> getContextResolver() {
        return renderableString;
    }

}
