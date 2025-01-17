package basicProject.javaSpring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env",havingValue = "Production")
public class ProdDb implements DbInterface{
    public String getData(){
        return "Production Data";
    }
}
