//package reaction.repository;
//
//
//import article.entity.RecommendArticle;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import reaction.entity.Reaction;
//
//import java.util.Optional;
//
//public interface ReactionCountRepository extends JpaRepository<Reaction, Long> {
//
//    @Query("select vote from Reaction vote " +
//            "join vote.account account " +
//            "join vote.article article " +
//            "where account.id = :accountId and article.id = :articleId")
//    Optional<Reaction> findByArticleAndAccount(@Param("accountId") Long accountId,
//                                                       @Param("articleId") Long articleId);
//}
