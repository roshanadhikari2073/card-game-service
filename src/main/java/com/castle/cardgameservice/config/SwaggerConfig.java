package com.castle.cardgameservice.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("cardgames")
                .pathsToMatch("/api/**")
                .build();
    }
}
