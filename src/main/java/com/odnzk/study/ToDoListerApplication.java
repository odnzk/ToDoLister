package com.odnzk.study;

import com.odnzk.study.util.PriorityConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ToDoListerApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListerApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PriorityConverter priorityConverter() {
        return new PriorityConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(priorityConverter());
    }

}
