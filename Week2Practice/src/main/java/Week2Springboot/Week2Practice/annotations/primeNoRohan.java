package Week2Springboot.Week2Practice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.PARAMETER})
@Constraint(validatedBy = {rohanPrimeNo.class})
public @interface  primeNoRohan {

    String message() default "Not a Valid Prime No";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
