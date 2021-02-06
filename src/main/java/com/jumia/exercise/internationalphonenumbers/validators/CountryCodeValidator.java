package com.jumia.exercise.internationalphonenumbers.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jumia.exercise.internationalphonenumbers.annotations.ValidCountryCode;

public class CountryCodeValidator implements ConstraintValidator<ValidCountryCode, String> {

    @Override
    public boolean isValid(String countryCode, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

}
