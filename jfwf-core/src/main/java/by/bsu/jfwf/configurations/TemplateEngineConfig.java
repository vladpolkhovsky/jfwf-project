package by.bsu.jfwf.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class TemplateEngineConfig {

    private static final String TEMPLATE_PREFIX = "templates/";

    private static final String TEMPLATE_SUFFIX = ".jfwftemplate";

    private static final int TEMPLATE_RESOLVER_ORDER = 1;

    private static final boolean TEMPLATE_RESOLVER_CACHEABLE = true;

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(templateResolver());
        return templateEngine;
    }

    private ITemplateResolver templateResolver() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix(TEMPLATE_PREFIX);
        resolver.setSuffix(TEMPLATE_SUFFIX);
        resolver.setTemplateMode(TemplateMode.XML);
        resolver.setOrder(TEMPLATE_RESOLVER_ORDER);
        resolver.setCacheable(TEMPLATE_RESOLVER_CACHEABLE);
        return resolver;
    }

}
