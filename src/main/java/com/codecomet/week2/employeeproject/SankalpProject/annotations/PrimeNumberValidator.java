package com.codecomet.week2.employeeproject.SankalpProject.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation,Integer> {
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        for(int i=2;i<=integer/2;i++){
            if(integer%i==0){
                return false;
            }
        }

        return true;
    }
}
