package com.jumia.exercise.internationalphonenumbers.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.jumia.exercise.internationalphonenumbers.validators.CountryCodeValidator;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryCodeValidator.class)
public @interface ValidCountryCode {

    String message() default "This country code is not valid!";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};

}
