package com.Spring.journey.Week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="bake.cake",havingValue = "Chocolate")
public class ChocolateCake implements Frosting,Syrup{
    public String getFrosting(){
        return "Chocolate Cake get Frosting ...";
    }
    public String getSyrup(){
        return "Chocolate Cake get Syrup ...";
    }
    @PostConstruct
    void beforeBake(){
        System.out.println("baker makes chocolate cake ...");
    }
    @PreDestroy
    void clean(){
        System.out.println("Chocolate Cake bakes .... Successfully");
    }
}
