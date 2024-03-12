package article.repository;

import article.entity.Article;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Internal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

//    private final EntityManager em;

    Article findByTitle(String title);

    @EntityGraph(attributePaths = {"articleId"}) // attributePaths를 이용해 연관된 엔티티를 지정해 페치 조인이 가능히다
    @Query("select article from Article article where article.id = :articleId")
    Optional<Article> findByIdWithAll(@Param("articleId") Long articleId);

    @EntityGraph(attributePaths = {"articleId"})
    @Query("select article from Article article where article.title like %:title%")
    Page<Article> searchByTitleWithAll(@Param("title") String title, Pageable pageable);

    @EntityGraph(attributePaths = {"articleId"})
    @Query("select article from Article article " +
            "join article.account account where account.id = :accountId")
    Page<Article> findByAccountWithAll(@Param("accountId") Long accountId, Pageable pageable);

    @EntityGraph(attributePaths = {"articleId"})
    @Query("select article from Article article where article.title like %:title% order by article.createAt desc")
    List<Article> findWithAllOrderByCreatedAt(@Param("title") String title);
}
