package com.odnzk.study.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI createConfig() {
        return new OpenAPI()
                .info(new Info()
                                .title("TodoLister")
                                .version("1.0.0")
                                .description("Application fot tracking projects and tasks")
                                .license(new License().name("TodoLister license"))
                                .contact(
                                        new Contact()
                                                .name("Odenezhkina")
                                                .email("todolister@gmail.com")));
    }
}
