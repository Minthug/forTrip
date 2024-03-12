package article.repository;

import article.entity.RecommendArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecommendVoteRepository extends JpaRepository<RecommendArticle, Long> {


    @Query("select vote from RecommendArticle vote " +
            "join vote.account account " +
            "join vote.article article " +
            "where account.id = :accountId and article.id = :articleId")
    Optional<RecommendArticle> findByArticleAndAccount(@Param("accountId") Long accountId,
                                                       @Param("articleId") Long articleId);
}
