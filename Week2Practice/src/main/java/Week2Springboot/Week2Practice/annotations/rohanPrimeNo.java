package Week2Springboot.Week2Practice.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class rohanPrimeNo implements ConstraintValidator<primeNoRohan,Integer> {
    @Override
    public boolean isValid(Integer isPrime, ConstraintValidatorContext constraintValidatorContext) {
        if (isPrime == null || isPrime <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(isPrime); i++) {
            if (isPrime % i == 0)  return false;
        }
        return true;
    }
}
