package ru.itis.school_api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PaswordAnnotation {
    String message() default "Bad password";

    String[] passwords() default {};

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
