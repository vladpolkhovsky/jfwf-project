package by.bsu.jfwf.services.dispatcher.impl;

import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.services.dispatcher.JfwfPageDispatcher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JfwfPageDispatcherImpl implements JfwfPageDispatcher {

    private final Map<String, PageComponent<? extends RenderableString>> pathToPage = new HashMap<>();

    @Override
    public <T extends RenderableString> void registerPage(String path, PageComponent<T> pageComponent) {
        pathToPage.put(path, pageComponent);
    }

    @Override
    public Map<String, PageComponent<? extends RenderableString>> getRegisteredPages() {
        return pathToPage;
    }

}
