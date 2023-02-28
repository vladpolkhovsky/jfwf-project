package by.bsu.jfwf;

import by.bsu.jfwf.components.ComponentBuilder;
import by.bsu.jfwf.components.container.VerticalLayoutComponent;
import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.components.text.LabelComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.ContextResolver;
import by.bsu.jfwf.services.dispatcher.JfwfPageDispatcher;
import by.bsu.jfwf.session.SessionContext;
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

        Function<SessionContext, String> contextStringFunction = t -> {
             if (t.get("counter") == null) {
                t.set("counter", 0);
             }
             t.set("counter", t.<Integer>get("counter") + 1);
             return "LabelComponent: " + t.get("counter");
         };

         ComponentBuilder<RenderableString> indexPage = PageComponent.builder()
                 .contextResolver(Renderable.staticText("Index page"));

         for (int i = 0; i < 100; i++) {
            indexPage.append(LabelComponent.build(Renderable.text(ContextResolver.<String>builder().apply(contextStringFunction))));
         }

         indexPage.append(VerticalLayoutComponent.builder()
                 .append(LabelComponent.build(Renderable.staticText("Col 1")))
                 .append(LabelComponent.build(Renderable.staticText("Col 2")))
                 .append(LabelComponent.build(Renderable.staticText("Col 3")))
                 .append(LabelComponent.build(Renderable.staticText("Col 4")))
                 .build()
         );

         PageComponent<RenderableString> page = (PageComponent<RenderableString>) indexPage.build();
            jfwfPageDispatcher.registerPage("index", page);
    }


}
