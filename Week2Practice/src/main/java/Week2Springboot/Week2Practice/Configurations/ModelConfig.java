package Week2Springboot.Week2Practice.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ModelConfig {

    @Bean
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }
}
