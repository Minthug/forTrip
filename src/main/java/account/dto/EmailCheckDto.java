package account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmailCheckDto {
    private String email;
    private String code;

    @Builder
    public EmailCheckDto(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
