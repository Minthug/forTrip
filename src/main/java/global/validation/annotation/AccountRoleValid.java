package global.validation.annotation;


import global.validation.validator.AccountRoleValidator;
import global.validation.validator.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {AccountRoleValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface AccountRoleValid {


    String message() default "Wrong AccountRole";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
