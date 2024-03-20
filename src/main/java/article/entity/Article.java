package article.entity;

import account.entity.Account;
import article.dto.ArticleReqDto;
import auditing.BaseTime;
import category.entity.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Builder
    public Article(Long id, String title, String content, String hashTag, Integer reactionCount, Integer viewCount, Boolean isSecret, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hashTag = hashTag;
        this.reactionCount = reactionCount;
        this.viewCount = viewCount;
        this.isSecret = isSecret;
        this.category = category;
    }

    public void updateAccount(Account account) {
        this.account = account;
    }

    public void updateCategory(Category category) {
        this.category = category;
    }

    public Article updateArticle(ArticleReqDto articleReqDto, Category category) {
        this.title = articleReqDto.getTitle();
        this.hashTag = articleReqDto.getHashTag();
        this.content = articleReqDto.getContent();
        this.isSecret = articleReqDto.getIsSecret();
        this.category = category;
        return this;
    }

    public void viewCount(Article article) {
        article.viewCount++;
    }

}
