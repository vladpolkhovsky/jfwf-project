package by.bsu.jfwf;

import by.bsu.jfwf.components.container.HorizontalLayoutComponent;
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

import java.util.function.Function;

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

        Function<String, ContextResolver<String>> displayVariable = (varName) -> {
            return ContextResolver.<String>builder().apply(t -> {
                return "Context variable '%s' = ".formatted(varName)
                    + t.getOrDefault(varName, 0);
            });
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
                .append(LabelComponent.build(Renderable.text(displayVariable.apply("input-1"))))
                .append(VerticalLayoutComponent.builder()
                    .append(ImageComponent.builder()
                        .path("/static/Java-Logo.png")
                        .build())
                    .append(ImageComponent.builder()
                        .path("/static/Java-Logo.png")
                        .build())
                    .append(ImageComponent.builder()
                        .path("/static/Java-Logo.png")
                        .build())
                    .build())
                .append(ImageComponent.builder()
                    .path("/static/Java-Logo.png")
                    .build())
                .build();

        jfwfPageDispatcher.registerPage("index", page);


        ContextResolver<String> contextResolver = ContextResolver.<String>builder().apply(t -> {
            return "Content variable 'var' = " + t.<String>getOrDefault("var", "valueOfVar5");
        });

        PageComponent<RenderableString> examplePage =
            (PageComponent<RenderableString>) PageComponent.builder()
                .contextResolver(Renderable.staticText("Example page"))
                .append(LabelComponent.build(Renderable.staticText("Static text")))
                .append(LabelComponent.build(Renderable.text(contextResolver)))
                .build();

        jfwfPageDispatcher.registerPage("textExample", examplePage);

        ActionCallback actionButtonClickCount = (t, er)
            -> {
            t.set("buttonClickCount", t.<Integer>getOrDefault("buttonClickCount", 0) + 1);
        };

        PageComponent<RenderableString> exampleUiPage =
            (PageComponent<RenderableString>) PageComponent.builder()
                .contextResolver(Renderable.staticText("Example UI page"))
                .append(LabelComponent.build(Renderable.text(displayVariable.apply("buttonClickCount"))))
                .append(LabelComponent.build(Renderable.text(displayVariable.apply("textFieldValue"))))
                .append(LabelComponent.build(Renderable.text(displayVariable.apply("textAreaValue"))))
                .append(ButtonComponent.builder()
                    .actionHandler(actionButtonClickCount)
                    .contextResolver(Renderable.staticText("buttonClickCount")).build())
                .append(TextFieldComponent.builder().actionHandler(actionCallback2).valueKeyName("textFieldValue")
                    .contextResolver(Renderable.staticText("textFieldValue"))
                    .build())
                .append(TextAreaComponent.builder().actionHandler(actionCallback2).valueKeyName("textAreaValue")
                    .contextResolver(Renderable.staticText("textAreaValue"))
                    .build())
                .build();

        jfwfPageDispatcher.registerPage("exampleUiPage", exampleUiPage);

        PageComponent<RenderableString> exampleImage =
            (PageComponent<RenderableString>) PageComponent.builder()
                .contextResolver(Renderable.staticText("Image example page"))
                .append(ImageComponent.builder()
                    .path("/static/Java-Logo.png")
                    .build())
                .append(ImageComponent.builder()
                    .path("/static/Java-Logo.png")
                    .size("50%", "auto")
                    .build())
                .build();

        jfwfPageDispatcher.registerPage("exampleImage", exampleImage);
    }


}
