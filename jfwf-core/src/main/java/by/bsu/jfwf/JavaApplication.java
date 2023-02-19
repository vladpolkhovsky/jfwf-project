package by.bsu.jfwf;

import by.bsu.jfwf.components.container.VerticalLayoutComponent;
import by.bsu.jfwf.resolver.logic.LogicResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);

        VerticalLayoutComponent.builder()
                .append()
                .appendIf(LogicResolver.create().apply(t -> t.get()), VerticalLayoutComponent.builder().build())
                .build();

    }

}
