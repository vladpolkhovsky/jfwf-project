package by.bsu.jfwfexample;

import by.bsu.jfwf.components.Component;
import by.bsu.jfwf.components.page.PageComponent;
import by.bsu.jfwf.components.text.LabelComponent;
import by.bsu.jfwf.render.Renderable;
import by.bsu.jfwf.render.impl.RenderableString;
import by.bsu.jfwf.resolver.content.ContentResolver;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import by.bsu.jfwf.session.SessionContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JfwfExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfwfExampleApplication.class, args);


        LogicResolver showLabel = LogicResolver.create().var("showLabel").apply((t) -> t.<Boolean>get("showLabel"));

        Component<RenderableString> page = PageComponent.builder()
                .contextResolver(Renderable.staticText("Tittle"))
                .append(LabelComponent.build(Renderable.staticText("Static label")))
                .append(LabelComponent.build(ContentResolver.create().var("counter").apply(t -> new Renderable() {
                    @Override
                    public String render(SessionContext sessionContext) {
                        return "Counter button pressed " + sessionContext.<Integer>get("counter") + " times";
                    }
                })))
                .appendIf(showLabel, LabelComponent.build(Renderable.staticText("Label component on showLabel is true")))
                .build();

    }

}
