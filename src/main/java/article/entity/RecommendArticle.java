package article.entity;


import account.entity.Account;
import auditing.BaseTime;
import global.VoteState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class RecommendArticle extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "recommendId")
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
    public RecommendArticle(Long id, VoteState state, Account account, Article article) {
        this.id = id;
        this.state = state;
        this.account = account;
        this.article = article;
    }
}
