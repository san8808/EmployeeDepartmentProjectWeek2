package com.codecomet.week2.employeeproject.SankalpProject.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;

public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if(password.length()<10){
            return false;
        }

        boolean hasUpperCase = password.matches(".*[A-Z].*");

        boolean hasLowerCase = password.matches(".*[a-z].*");

        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");

        return hasLowerCase && hasUpperCase && hasSpecialChar;
    }
}
