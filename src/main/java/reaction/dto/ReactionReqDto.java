package reaction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionReqDto {

    private Long accountId;
    private Long articleId;

    public ReactionReqDto(Long accountId, Long articleId) {
        this.accountId = accountId;
        this.articleId = articleId;
    }
}
