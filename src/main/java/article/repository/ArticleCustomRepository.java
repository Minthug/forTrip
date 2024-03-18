package article.repository;

import article.dto.ArticleResDto;
import article.entity.Article;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCustomRepository {

    PageImpl<ArticleResDto> getArticleList(String query, Pageable pageable);

    ArticleResDto getArticleWithTag(Long id);

    void addReactionCount(Article article);

    void subReactionCount(Article article);


}
