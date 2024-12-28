package com.spingjourney.Week2Homework.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {

    @Bean
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }
}
