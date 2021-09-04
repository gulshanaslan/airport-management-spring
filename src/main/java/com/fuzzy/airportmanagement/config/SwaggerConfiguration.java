package com.fuzzy.airportmanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${Swagger.api-info.title}")
    private String title;
    @Value("${Swagger.api-info.desc}")
    private String desc;
    @Value("${Swagger.api-info.version}")
    private String version;
    @Value("${Swagger.api-info.contact.name}")
    private String name;
    @Value("${Swagger.api-info.contact.url}")
    private String url;
    @Value("${Swagger.api-info.contact.mail}")
    private String mail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .version(version)
                .contact(new Contact(name, url, mail))
                .build();
    }
}
