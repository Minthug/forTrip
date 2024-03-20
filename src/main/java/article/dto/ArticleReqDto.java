package article.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleReqDto {

    private Long AccountId;
    private Long cateId;
    private String hashTag;
    private String title;
    private String content;
    private Boolean isSecret;


    public ArticleReqDto(Long accountId, Long cateId, String hashTag, String title, String content, Boolean isSecret) {
        AccountId = accountId;
        this.cateId = cateId;
        this.hashTag = hashTag;
        this.title = title;
        this.content = content;
        this.isSecret = isSecret;
    }
}

