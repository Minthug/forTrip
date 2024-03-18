//
//package article.repository;
//
//import article.dto.ArticleResDto;
//import article.entity.Article;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Repository
//public class ArticleRepositoryImpl implements ArticleCustomRepository {
//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public PageImpl<ArticleResDto> getArticleList(String query, Pageable pageable) {
//
//        List<Article> articleList = queryFactory
//                .selectFrom();
//
//        return null;
//    }
//
//    @Override
//    public ArticleResDto getArticleWithTag(Long id) {
//        return null;
//    }
//
//    @Override
//    public void addReactionCount(Article article) {
//
//    }
//
//    @Override
//    public void subReactionCount(Article article) {
//
//    }
//}
