package by.bsu.jfwf.services.dispatcher;

import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.impl.RenderableString;

import java.util.Map;

public interface JfwfPageDispatcher {

    <T extends RenderableString> void registerPage(String path, PageComponent<T> pageComponent);

    Map<String, PageComponent<? extends RenderableString>> getRegisteredPages();

}
