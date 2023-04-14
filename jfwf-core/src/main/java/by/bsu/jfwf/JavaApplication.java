package by.bsu.jfwf;

import by.bsu.jfwf.components.container.HorizontalLayoutComponent;
import by.bsu.jfwf.components.container.VerticalLayoutComponent;
import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.components.text.LabelComponent;
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
        PageComponent<RenderableString> page =
            (PageComponent<RenderableString>) PageComponent.builder()
                .contextResolver(Renderable.staticText("Example page"))
                .append(VerticalLayoutComponent.builder()
                    .append(LabelComponent.build(Renderable.staticText("Col 1")))
                    .append(VerticalLayoutComponent.builder()
                        .append(LabelComponent.build(Renderable.staticText("Col 2.1")))
                        .append(HorizontalLayoutComponent.builder()
                            .append(LabelComponent.build(Renderable.staticText("Col 2.2.1")))
                            .append(LabelComponent.build(Renderable.staticText("Col 2.2.2")))
                            .append(LabelComponent.build(Renderable.staticText("Col 2.2.3")))
                            .build())
                        .append(LabelComponent.build(Renderable.staticText("Col 2.3")))
                        .build())
                    .append(LabelComponent.build(Renderable.staticText("Col 3")))
                    .build())
                .build();

        jfwfPageDispatcher.registerPage("index", page);
    }


}
