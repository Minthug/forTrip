package article.dto;

import account.entity.Account;
import article.entity.Article;
import article.entity.RecommendArticle;
import global.VoteState;
import lombok.Data;

@Data
public class ArticleVoteResDto {

    private VoteState voteState;

    public RecommendArticle toArticleVote(Long accountId, Long articleId) {
        return RecommendArticle.builder()
                .account(new Account(accountId))
                .article(Article.builder()
                        .id(articleId)
                        .build())
                .state(this.voteState)
                .build();
    }
}
