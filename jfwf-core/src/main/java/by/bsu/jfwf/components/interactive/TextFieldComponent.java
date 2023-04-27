package by.bsu.jfwf.components.interactive;

import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.services.dispatcher.impl.EventHandlerImpl;

import java.util.LinkedHashMap;
import java.util.UUID;

public class TextFieldComponent extends AbstractComponent<RenderableString> {

    private final String actionId;

    private final String valueKeyName;

    private final ContentResolver<RenderableString> renderableString;

    protected TextFieldComponent(ContentResolver<RenderableString> renderableString, ActionCallback actionCallback, String valueKeyName) {
        super(new LinkedHashMap<>());
        this.renderableString = renderableString;
        this.actionId = UUID.randomUUID().toString();
        this.valueKeyName = valueKeyName;
        EventHandlerImpl.set(actionId, actionCallback);
    }

    public static TextFieldComponentBuilder<RenderableString> builder() {
        return new TextFieldComponentBuilder<>();
    }

    public String getActionId() {
        return actionId;
    }

    public String getValueKeyName() {
        return valueKeyName;
    }

    @Override
    public ContextResolver<RenderableString> getContextResolver() {
        return renderableString;
    }

}
