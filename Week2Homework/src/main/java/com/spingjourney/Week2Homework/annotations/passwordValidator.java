package com.spingjourney.Week2Homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Null;

public class passwordValidator implements ConstraintValidator<passwordChecker,String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null || password.length() < 10) {
                return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
              if (Character.isUpperCase(c)) {
                  hasUppercase = true;
              }
              else if (Character.isLowerCase(c)) {
                  hasLowercase = true;
              }
              else if (!Character.isLetterOrDigit(c)) {
                  hasSpecialChar = true;
              }
          }
        return hasUppercase && hasLowercase && hasSpecialChar;
    }
}
