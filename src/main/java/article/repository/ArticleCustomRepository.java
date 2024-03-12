package article.repository;

import article.entity.Article;

public interface ArticleCustomRepository {

    void addReactionCount(Article article);

    void subReactionCount(Article article);

}
