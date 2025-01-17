package com.Spring.journey.Week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="bake.cake",havingValue = "Strawberry")
public class StrawberryCake implements Frosting,Syrup{
    public String getFrosting(){
        return "Strawberry Cake get Frosting ...";
    }
    public String getSyrup(){
        return "Strawberry Cake get Syrup ...";
    }
    @PostConstruct
    void beforeBake(){
        System.out.println("baker makes Strawberry cake ...");
    }
    @PreDestroy
    void clean(){
        System.out.println("Strawberry Cake bakes .... Successfully");
    }

}
