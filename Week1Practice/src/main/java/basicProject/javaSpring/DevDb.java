package basicProject.javaSpring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env",havingValue = "Development")
public class DevDb implements DbInterface{

    public String getData(){
        return "Development Data";
    }
}
