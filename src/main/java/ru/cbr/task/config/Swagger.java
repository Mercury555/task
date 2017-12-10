package ru.cbr.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by total on 30.07.2017.
 */
@EnableSwagger2
@Configuration
public class Swagger {
    @Bean
    public Docket api(
            @Value("${crm.api.host}") String host,
            @Value("${crm.api.path}") String path
    ) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        docket.host(host);
        docket.pathMapping(path);
        return docket;
    }
}
