package by.bsu.jfwf.components.interactive;

import by.bsu.jfwf.components.impl.AbstractComponentBuilder;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;

public class TextAreaComponentBuilder<T extends RenderableString> extends AbstractComponentBuilder<RenderableString> {

    private ActionCallback actionCallback;

    private String valueKeyName;

    public TextAreaComponentBuilder<T> actionHandler(ActionCallback actionCallback) {
        this.actionCallback = actionCallback;
        return this;
    }

    public TextAreaComponentBuilder<T> valueKeyName(String valueKeyName) {
        this.valueKeyName = valueKeyName;
        return this;
    }

    @Override
    public TextAreaComponent build() {
        return new TextAreaComponent(contentResolver, actionCallback, valueKeyName);
    }

}
