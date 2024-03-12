package comment.entity;

import account.entity.Account;
import article.entity.Article;
import auditing.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "commentId")
    private Long id;

    private String content;

    @ColumnDefault("FALSE")
    @Column(nullable = false) // 삭제유무 true 시 삭제된 댓글, 디폴트 false
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    /*
    * 부모 댓글 null일 경우 최상위 댓글
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Comment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId")
    private Article article;

    public Comment(String content) {
        this.content = content;
    }

    @Builder
    public Comment(Long id, String content, Boolean isDeleted, Account account, Comment parent, Article article) {
        this.id = id;
        this.content = content;
        this.isDeleted = isDeleted;
        this.account = account;
        this.parent = parent;
        this.article = article;
    }

    public void updateAccount(Account account) {
        this.account = account;
    }

    public void updateArticle(Article article) {
        this.article = article;
    }

    public void updateParent(Comment comment) {
        this.parent = parent;
    }

    public void changeIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void updateContent(String content) {
        this.content = content;
    }

}
