package by.bsu.jfwf.services.components;

import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.impl.RenderableString;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface JfwfPageAssembler {

    void createPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, PageComponent<?> pageComponent) throws IOException;

}
