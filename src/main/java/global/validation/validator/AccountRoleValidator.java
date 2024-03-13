package global.validation.validator;

import account.entity.Account;
import account.entity.AccountRole;
import global.utils.MessageUtils;
import global.validation.annotation.AccountRoleValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountRoleValidator implements ConstraintValidator<AccountRoleValid, AccountRole> {

    @Override
    public void initialize(AccountRoleValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(AccountRole accountRole, ConstraintValidatorContext context) {
        if (accountRole == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(MessageUtils.getMessage("accountRole.valid.message"))
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
