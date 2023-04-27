package by.bsu.jfwf.components.interactive;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.impl.AbstractComponentBuilder;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;

public class ButtonComponentBuilder<T extends RenderableString> extends AbstractComponentBuilder<RenderableString> {

    private ActionCallback actionCallback;

    public ButtonComponentBuilder<T> actionHandler(ActionCallback actionCallback) {
        this.actionCallback = actionCallback;
        return this;
    }

    @Override
    public ButtonComponent build() {
        return new ButtonComponent(contentResolver, actionCallback);
    }

}
