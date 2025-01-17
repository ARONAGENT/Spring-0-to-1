package com.Spring.journey.Week1;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakeryService {
//    @Autowired
//    private Frosting f;
//
//    @Autowired
//    private Syrup s;

    // Second Method without using Field Injection @Autowired
    private Frosting f;
    private Syrup s;
    public BakeryService(Frosting f,Syrup s){
        this.f=f;
        this.s=s;
    }
    String bakeCake(){
        return  s.getSyrup()+"\n"+f.getFrosting();
    }

}
