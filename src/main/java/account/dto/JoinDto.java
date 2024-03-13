package account.dto;

import account.entity.AccountRole;
import global.validation.annotation.AccountRoleValid;
import global.validation.annotation.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinDto {

    @NotBlank
    @Email
    private String email;

    @Password
    private String password;

    @AccountRoleValid
    private AccountRole accountRole;

    @Builder
    public JoinDto(String email, String password, AccountRole accountRole) {
        this.email = email;
        this.password = password;
        this.accountRole = accountRole;
    }
}
