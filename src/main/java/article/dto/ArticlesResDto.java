package article.dto;

import account.dto.ArticleAccountResDto;
import article.entity.Article;
import article.entity.RecommendArticle;
import auditing.BaseTime;
import global.VoteState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArticlesResDto extends BaseTime {

    private Long id;
    private String title;
    private String content;
    private long totalVote;
    private ArticleAccountResDto account;

    public ArticlesResDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.totalVote = getTotalVote(article.getArticleVotes());
        this.account = new ArticleAccountResDto();
        setCreateAt(article.getCreateAt());
        setModifiedAt(article.getModifiedAt());
    }

    private long getTotalVote(List<RecommendArticle> articleVotes) {
        int voteSize = articleVotes.size();
        long voteUpCount = articleVotes.stream()
                .filter(articleVote -> articleVote.getState().equals(VoteState.UP))
                .count();
        return 2 * voteUpCount - voteSize;
    }


}
