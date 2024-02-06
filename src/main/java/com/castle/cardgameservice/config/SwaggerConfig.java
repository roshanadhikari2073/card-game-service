package com.castle.cardgameservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures SpringDoc's OpenAPI for generating API documentation using Swagger UI.
 *
 * @author Roshan Adhikari
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API")
                        .version("1")
                        .description("API for card game service"));
    }
}
