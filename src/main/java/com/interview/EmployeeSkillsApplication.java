package com.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Application initialization.
 * @author jrcej 11/25/2020
 */
@SpringBootApplication
public class EmployeeSkillsApplication {


    public static void main(String[] args) {
        SpringApplication.run(EmployeeSkillsApplication.class, args);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2Converter() {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint(true);
        return converter;
    }
}
