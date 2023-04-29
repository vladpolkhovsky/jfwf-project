package by.bsu.jfwf;

import by.bsu.jfwf.components.container.VerticalLayoutComponent;
import by.bsu.jfwf.components.image.ImageComponent;
import by.bsu.jfwf.components.interactive.ButtonComponent;
import by.bsu.jfwf.components.interactive.TextAreaComponent;
import by.bsu.jfwf.components.interactive.TextFieldComponent;
import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.components.text.LabelComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ActionCallback;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.resolver.content.ContentResolver;
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
        ContentResolver<RenderableString> counterText = Renderable.text(ContextResolver.<String>builder().apply(t -> {
            return "Counter is " + t.getOrDefault("counter", 0);
        }));

        ActionCallback actionCallback = (t, eventRequest) -> {
            Integer counter = t.getOrDefault("counter", 0);
            t.set("counter", counter + 1);
        };

        ActionCallback actionCallback2 = (t, eventRequest) -> {

        };

        PageComponent<RenderableString> page =
            (PageComponent<RenderableString>) PageComponent.builder()
                .contextResolver(Renderable.staticText("Example page"))
                .append(VerticalLayoutComponent.builder()
                    .append(LabelComponent.build(counterText))
                    .build())
                .append(ButtonComponent.builder()
                    .actionHandler(actionCallback)
                    .contextResolver(Renderable.staticText("Add 1")).build())
                .append(TextFieldComponent.builder()
                    .actionHandler(actionCallback2)
                    .valueKeyName("input-1")
                    .contextResolver(Renderable.staticText("Text field"))
                    .build())
                .append(TextAreaComponent.builder()
                    .actionHandler(actionCallback2)
                    .valueKeyName("input-2")
                    .contextResolver(Renderable.staticText("Text area"))
                    .build())
                .append(ImageComponent.builder()
                    .path("/static/Java-Logo.png")
                    .build())
                .append(ImageComponent.builder()
                    .path("/static/Java-Logo.png")
                    .size("50%", "auto")
                    .build())
                .build();

        jfwfPageDispatcher.registerPage("index", page);
    }


}
