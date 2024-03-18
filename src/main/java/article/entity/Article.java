package article.entity;

import account.entity.Account;
import article.dto.ArticleReqDto;
import auditing.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor
public class Article extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "articleId")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "hashTag")
    private String hashTag;

    @ColumnDefault("0")
    @Column(name = "reactionCount", nullable = false)
    private Integer reactionCount;

    @ColumnDefault("0")
    @Column(name = "viewCount", nullable = false)
    private Integer viewCount;

    @ColumnDefault("0")
    @Column(name = "commentCount", nullable = false)
    private Integer commentCount;

    @ManyToOne(fetch = FetchType.LAZY) // ManyToOne 은 항상 연관관계의 주인
    @JoinColumn(name = "accountId")
    private Account account;

    @Column(name = "isSecret", nullable = false)
    private Boolean isSecret;


    @Builder
    public Article(Long id, String title, String content, String hashTag, Integer reactionCount, Integer viewCount, Integer commentCount, Account account, Boolean isSecret) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hashTag = hashTag;
        this.reactionCount = reactionCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.account = account;
        this.isSecret = isSecret;
    }

    public void updateAccount(Account account) {
        this.account = account;
    }

    public Article updateArticle(ArticleReqDto articleReqDto) {
        this.title = articleReqDto.getTitle();
        this.hashTag = articleReqDto.getHasgTag();
        this.content = articleReqDto.getContent();
        this.isSecret = articleReqDto.getIsSecret();

        return this;
    }

    public void viewCount(Article article) {
        article.viewCount++;
    }
    public void modify(Article article) {
        Optional.ofNullable(article.getTitle()).ifPresent(title -> this.title = title);
        Optional.ofNullable(article.getContent()).ifPresent(content -> this.content = content);
    }
}
