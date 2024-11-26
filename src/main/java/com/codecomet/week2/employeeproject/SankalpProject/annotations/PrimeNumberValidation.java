package com.codecomet.week2.employeeproject.SankalpProject.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PrimeNumberValidator.class})
public @interface PrimeNumberValidation {

    String message() default "Error - Expected Prime Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
