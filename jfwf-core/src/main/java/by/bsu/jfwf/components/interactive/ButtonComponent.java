package by.bsu.jfwf.components.interactive;

import by.bsu.jfwf.components.impl.AbstractComponent;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.services.dispatcher.impl.EventHandlerImpl;

import java.util.LinkedHashMap;
import java.util.UUID;

public class ButtonComponent extends AbstractComponent<RenderableString> {

    private final String actionId;
    private final ContentResolver<RenderableString> renderableString;

    protected ButtonComponent(ContentResolver<RenderableString> renderableString, ActionCallback actionCallback) {
        super(new LinkedHashMap<>());
        this.renderableString = renderableString;
        this.actionId = UUID.randomUUID().toString();
        EventHandlerImpl.set(actionId, actionCallback);
    }

    public static ButtonComponentBuilder<RenderableString> builder() {
        return new ButtonComponentBuilder<>();
    }

    public String getActionId() {
        return actionId;
    }

    @Override
    public ContextResolver<RenderableString> getContextResolver() {
        return renderableString;
    }
}
