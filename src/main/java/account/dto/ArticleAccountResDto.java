package account.dto;


import account.entity.Account;
import account.entity.AccountRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleAccountResDto {

    private Long id;
    private String email;
    private String nickname;
    private AccountRole role;

    public ArticleAccountResDto(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.nickname = account.getNickname();
        this.role = account.getRole();
    }

    @Builder
    public ArticleAccountResDto(Long id, String email, String nickname, AccountRole role) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }
}
