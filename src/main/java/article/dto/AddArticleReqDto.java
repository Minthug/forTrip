package article.dto;

import account.entity.Account;
import article.entity.Article;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddArticleReqDto {

    @NotBlank
    private String title;

    @Length(min = 50)
    private String content;

    public Article toArticle(Long accountId) {
        return Article.builder()
                .title(title)
                .content(content)
                .account(new Account(accountId))
                .build();
    }
}
