package reaction.entity;

import account.entity.Account;
import article.entity.Article;
import global.VoteState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "reaction")
public class Reaction {

    @Id
    @GeneratedValue
    @Column(name = "reactionId")
    private Long id;

    @Enumerated(EnumType.STRING)
    private VoteState state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId")
    private Article article;

    @Builder
    public Reaction(VoteState state, Account account, Article article) {
        this.state = state;
        this.account = account;
        this.article = article;
    }
}
