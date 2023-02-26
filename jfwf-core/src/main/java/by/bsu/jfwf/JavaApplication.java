package by.bsu.jfwf;

import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.services.dispatcher.JfwfPageDispatcher;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication {

    private final JfwfPageDispatcher jfwfPageDispatcher;

    public JavaApplication(JfwfPageDispatcher jfwfPageDispatcher) {
        this.jfwfPageDispatcher = jfwfPageDispatcher;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

    @PostConstruct
    void init() {
        PageComponent<RenderableString> page = (PageComponent<RenderableString>) PageComponent.builder()
                .contextResolver(Renderable.staticText("Index page"))
                .build();
        jfwfPageDispatcher.registerPage("index", page);
    }

}
