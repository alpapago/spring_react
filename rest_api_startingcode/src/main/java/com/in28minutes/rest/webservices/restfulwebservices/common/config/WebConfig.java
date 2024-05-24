package com.in28minutes.rest.webservices.restfulwebservices.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000",
                        "http://localhost:3333",
                        "http://localhost:5173",
                        "https://dear103.store"
                )
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .exposedHeaders("Authorization")
                .allowCredentials(true)
                .maxAge(3000);
    }
}