package com.pruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class PruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebasApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	                @Override
	                public void addCorsMappings(CorsRegistry registry) {
	                        registry.addMapping("/V1/personas/*")
	                                .allowedOrigins("*")
	                                .maxAge(3600);
	                        registry.addMapping("/V1/Orders/*")
                            .allowedOrigins("*")
                            .maxAge(3600);
	                        registry.addMapping("/V1/products/*")
                            .allowedOrigins("*")
                            .maxAge(3600);
	                }

	        };
	}

}
