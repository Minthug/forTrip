package account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 666095843L;

    public static final QAccount account = new QAccount("account");

    public final auditing.QBaseTime _super = new auditing.QBaseTime(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final ListPath<article.entity.Article, article.entity.QArticle> articleList = this.<article.entity.Article, article.entity.QArticle>createList("articleList", article.entity.Article.class, article.entity.QArticle.class, PathInits.DIRECT2);

    public final ListPath<comment.entity.Comment, comment.entity.QComment> commentList = this.<comment.entity.Comment, comment.entity.QComment>createList("commentList", comment.entity.Comment.class, comment.entity.QComment.class, PathInits.DIRECT2);

    public final StringPath country = createString("country");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final DateTimePath<java.time.LocalDateTime> createDay = createDateTime("createDay", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final StringPath emailCode = createString("emailCode");

    public final BooleanPath emailVerified = createBoolean("emailVerified");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final EnumPath<AccountRole> role = createEnum("role", AccountRole.class);

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

