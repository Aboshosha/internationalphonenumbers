package com.jumia.exercise.internationalphonenumbers.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.jumia.exercise.internationalphonenumbers.validators.StateValidator;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StateValidator.class)
public @interface ValidState {

    String message() default "This state is not valid!";

    String country();

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
}
