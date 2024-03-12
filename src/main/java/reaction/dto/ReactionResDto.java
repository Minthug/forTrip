package reaction.dto;

import account.entity.Account;
import article.entity.Article;
import global.VoteState;
import lombok.Data;
import reaction.entity.Reaction;


@Data
public class ReactionResDto {

        private VoteState voteState;

        public Reaction toArticleVote(Long accountId, Long articleId) {
            return Reaction.builder()
                    .account(new Account(accountId))
                    .article(Article.builder()
                            .id(articleId)
                            .build())
                    .state(this.voteState)
                    .build();
        }
    }
