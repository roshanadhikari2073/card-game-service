package com.castle.cardgameservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Redirects the base URL to Swagger UI.
 *
 * @author Roshan Adhikari
 */
@Controller
public class SwaggerController {

    @GetMapping("/")
    public String redirect() {
        return "redirect:/swagger-ui/index.html"; // Use "/swagger-ui.html" if needed
    }
}
