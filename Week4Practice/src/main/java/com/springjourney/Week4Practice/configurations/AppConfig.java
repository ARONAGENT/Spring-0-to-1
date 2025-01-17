package com.springjourney.Week4Practice.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.springjourney.Week4Practice.auth.AuditableAware;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef ="getAuditableAware" )

public class AppConfig {

    @Bean
    ModelMapper createNewModelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditableAware(){
        return new AuditableAware();
    }
}
