package by.bsu.jfwf.controllers;

import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.services.components.JfwfPageAssembler;
import by.bsu.jfwf.services.dispatcher.JfwfPageDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/p")
public class JfwfPageController {

    private final JfwfPageDispatcher jfwfPageDispatcher;

    private final JfwfPageAssembler jfwfPageAssembler;

    public JfwfPageController(JfwfPageDispatcher jfwfPageDispatcher, JfwfPageAssembler jfwfPageAssembler) {
        this.jfwfPageDispatcher = jfwfPageDispatcher;
        this.jfwfPageAssembler = jfwfPageAssembler;
    }

    @GetMapping("/{pageName}")
    void resolvePageRequest(@PathVariable String pageName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        PageComponent<RenderableString> pageComponent = (PageComponent<RenderableString>) jfwfPageDispatcher.getRegisteredPages().get(pageName);
        jfwfPageAssembler.createPage(httpServletRequest, httpServletResponse, pageComponent);

    }

}
