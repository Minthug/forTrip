package reaction.repository;

import account.entity.Account;
import article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reaction.entity.Reaction;

import java.util.Optional;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    Optional<Reaction> findByAccountAndArticle(Account account, Article article);
}
