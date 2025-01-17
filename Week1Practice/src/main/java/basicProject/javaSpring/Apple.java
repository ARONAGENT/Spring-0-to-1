package basicProject.javaSpring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Apple {

    void eatApple(){
        System.out.print("Eating apple ");
    }
    @PostConstruct
    void beforeEat(){
        System.out.println("Before Call the apple ");
    }
    @PreDestroy
    void clean(){
        System.out.println("Done Calling and stop Successfully");
    }


}
