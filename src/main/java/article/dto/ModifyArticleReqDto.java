package article.dto;

import account.entity.Account;
import article.entity.Article;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ModifyArticleReqDto {

    @NotBlank
    private String title;

    @Length(min = 50)
    private String content;

    public Article toArticle(Long accountId, Long articleId) {
        return Article.builder()
                .id(articleId)
                .title(title)
                .content(content)
                .account(new Account(accountId))
                .build();
    }
}
