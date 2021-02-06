package com.jumia.exercise.internationalphonenumbers.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jumia.exercise.internationalphonenumbers.annotations.ValidState;

public class StateValidator implements ConstraintValidator<ValidState, String> {

    @Override
    public void initialize(ValidState validState) {
    }

    @Override
    public boolean isValid(String state, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

}
