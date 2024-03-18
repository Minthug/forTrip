package account.dto;

import account.entity.Account;
import account.entity.AccountRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String email;
    private String nickname;
    private AccountRole accountRole;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.nickname = account.getNickname();
        this.accountRole = account.getRole();
    }

    @Builder
    public AccountDto(Long id, String email, String nickname, AccountRole accountRole) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.accountRole = accountRole;
    }
}
