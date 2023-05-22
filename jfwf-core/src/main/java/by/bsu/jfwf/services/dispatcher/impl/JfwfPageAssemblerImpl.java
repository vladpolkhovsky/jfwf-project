package by.bsu.jfwf.services.dispatcher.impl;

import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.services.components.ComponentRenderer;
import by.bsu.jfwf.services.components.JfwfPageAssembler;
import by.bsu.jfwf.session.SessionContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class JfwfPageAssemblerImpl implements JfwfPageAssembler {

    private final List<ComponentRenderer> componentRenderers;

    @Autowired
    private SessionContext sessionContext;

    public JfwfPageAssemblerImpl(List<ComponentRenderer> componentRenderers) {
        this.componentRenderers = componentRenderers;
    }

    @Override
    public void createPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, PageComponent<?> pageComponent) throws IOException {
        String pageBody = "NOT FOUND";
        for (ComponentRenderer componentRenderer : componentRenderers) {
            if (Objects.equals(componentRenderer.renderedClass(), pageComponent.getClass())) {
                pageBody = componentRenderer.render(sessionContext, pageComponent);
            }
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType(MediaType.TEXT_HTML_VALUE);
        httpServletResponse.getWriter().print(pageBody);
    }

}
