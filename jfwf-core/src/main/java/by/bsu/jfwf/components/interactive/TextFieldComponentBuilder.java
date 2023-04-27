package by.bsu.jfwf.components.interactive;

import by.bsu.jfwf.components.impl.AbstractComponentBuilder;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;

public class TextFieldComponentBuilder<T extends RenderableString> extends AbstractComponentBuilder<RenderableString> {

    private ActionCallback actionCallback;

    private String valueKeyName;

    public TextFieldComponentBuilder<T> actionHandler(ActionCallback actionCallback) {
        this.actionCallback = actionCallback;
        return this;
    }

    public TextFieldComponentBuilder<T> valueKeyName(String valueKeyName) {
        this.valueKeyName = valueKeyName;
        return this;
    }

    @Override
    public TextFieldComponent build() {
        return new TextFieldComponent(contentResolver, actionCallback, valueKeyName);
    }

}
