package article.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleReqDto {

    private Long AccountId;
    private String hasgTag;
    private String title;
    private String content;
    private Boolean isSecret;


    public ArticleReqDto(Long accountId, String hasgTag, String title, String content, Boolean isSecret) {
        AccountId = accountId;
        this.hasgTag = hasgTag;
        this.title = title;
        this.content = content;
        this.isSecret = isSecret;
    }
}

