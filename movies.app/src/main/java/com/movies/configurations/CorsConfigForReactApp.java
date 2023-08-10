package com.movies.configurations;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigForReactApp {
	
	@Value("${cross-origin-url}")
	private String CROSS_ORIGIN_URL;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	System.out.println(CROSS_ORIGIN_URL);
                registry.addMapping("/**").allowedOrigins(CROSS_ORIGIN_URL);
            }
        };
    }
}