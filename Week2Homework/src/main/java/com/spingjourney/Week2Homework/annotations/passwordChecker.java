package com.spingjourney.Week2Homework.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = passwordValidator.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface passwordChecker {

    String message() default "Password must be at least 10 characters long and contain one uppercase letter, one lowercase letter, and one special character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
