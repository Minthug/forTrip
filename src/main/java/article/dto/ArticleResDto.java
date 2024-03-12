package article.dto;


import account.dto.ArticleAccountResDto;
import article.entity.Article;
import article.entity.RecommendArticle;
import auditing.BaseTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import global.VoteState;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ArticleResDto extends BaseTime {

    private Long id;
    private String title;
    private String hashTag;
    private String content;
    private Integer reactionCount;
    private Integer viewCount;
    private Integer commentCount;
    private List<ArticleAccountResDto> articleAccountResDtoList;

    @Builder
    public ArticleResDto(Long id, String title, String hashTag,
                         String content, Integer reactionCount,
                         Integer viewCount, Integer commentCount,
                         List<ArticleAccountResDto> articleAccountResDtoList) {

        this.id = id;
        this.title = title;
        this.hashTag = hashTag;
        this.content = content;
        this.reactionCount = reactionCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.articleAccountResDtoList = articleAccountResDtoList;
    }
//
//    private long getTotalVote(List<RecommendArticle> articleVotes) {
//        int voteSize = articleVotes.size();
//        long voteUpCount = articleVotes.stream()
//                .filter(recommendArticle -> recommendArticle.getState().equals(VoteState.UP))
//                .count();
//        return 2 * voteUpCount - voteSize;
//    }

    @Builder
    public ArticleResDto(Long id, String title, String hashTag,
                         String content, Integer reactionCount,
                         Integer viewCount, Integer commentCount) {
        this.id = id;
        this.title = title;
        this.hashTag = hashTag;
        this.content = content;
        this.reactionCount = reactionCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
    }
}
