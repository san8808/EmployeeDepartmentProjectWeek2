package com.codecomet.week2.employeeproject.SankalpProject.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordValidation {

    String message() default "Please enter a valid password - Must contain an UpperCase & Lowercase letter, Special Character, Min length >=10";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
