package com.kamal.getmesocial.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCreatedByCons implements ConstraintValidator<ValidCreatedBy, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.matches("^[a-z0-9 .]+$")){
            return true;
        }else{
            return false;
        }
    }
}
