package account.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.util.StringUtils;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum AccountRole {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static AccountRole fromUserRole(String value) {
        return Stream.of(AccountRole.values())
                .filter(accountRole -> StringUtils.equals(accountRole.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
