package account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountUpdateDto {
    private String nickname;
    private String password;

    @Builder
    public AccountUpdateDto(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
