package account.dto;

import account.entity.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class PostAccountDto {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$\",",
            message = "Invalid email format")
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-zA-ZS]).{8,}",
    message = "Must contain at least one letter and one number, and be at least 8 characters long.")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z가-헿0-9]{4,}$",
            message = "Must be at least 4 characters long and contain no special characters.")
    private String nickname;

//    public Account ToAccount(String profilePath) {
//        Account account = new Account();
//        account.setEmail(this.email);
//        account.setPassword(this.password);
//        account.setNickname(this.nickname);
//
//        return account;
//    }

    @Builder
    public PostAccountDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
