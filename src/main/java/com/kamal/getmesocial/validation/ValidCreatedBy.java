package com.kamal.getmesocial.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCreatedByCons.class)
@Documented

public @interface ValidCreatedBy {
    String message() default "Not a valid Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
