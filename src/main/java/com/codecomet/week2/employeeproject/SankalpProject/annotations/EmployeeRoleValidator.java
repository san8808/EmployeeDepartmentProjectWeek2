package com.codecomet.week2.employeeproject.SankalpProject.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null) return false;

        List<String> roles=List.of("USER","ADMIN");
        return roles.contains(s);
    }
}
