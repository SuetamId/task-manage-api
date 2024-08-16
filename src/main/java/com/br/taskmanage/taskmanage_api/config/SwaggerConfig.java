package com.br.taskmanage.taskmanage_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI().info(new Info()
                .title("Task Manager")
                .description("API Task Manager")
                .contact(new Contact().name("Mateus Oliveira").email("mmcc.silveira@gmail.com"))
                .version("1.0.0")
        );
    }
}
