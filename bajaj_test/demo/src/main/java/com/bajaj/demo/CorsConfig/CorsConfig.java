package com.bajaj.demo.CorsConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public abstract class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api")
                .allowedOrigins("http://localhost:8080") // Replace with your frontend origin
                .allowedMethods("POST") // Allowed HTTP methods (e.g., GET, POST)
                .allowedHeaders("*"); // Allowed headers (e.g., Content-Type)
    }

    public abstract void addCorsMAppings(CorsRegistry registry);
}
