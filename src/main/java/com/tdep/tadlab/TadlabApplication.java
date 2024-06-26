package com.tdep.tadlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(exclude = {
    SecurityAutoConfiguration.class,
    UserDetailsServiceAutoConfiguration.class
})
public class TadlabApplication {
  public static void main(String[] args) {
    SpringApplication.run(TadlabApplication.class, args);
  }

// TODO: Change allowedOrigins


  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1")
            .allowedOrigins("http://localhost:3000", "PostmanRuntime/7.37.0");
      }
    };
  }
}

//TODO: Create API key string for environment variable in BFF and here
