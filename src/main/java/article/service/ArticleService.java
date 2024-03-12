package article.service;

import account.repository.AccountRepository;
import article.entity.Article;
import article.entity.RecommendArticle;
import article.repository.ArticleRepository;
import article.repository.RecommendVoteRepository;
import global.advice.BusinessLogicException;
import global.exceptionCode.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AccountRepository accountRepository;
    private final RecommendVoteRepository recommendVoteRepository;

    @Transactional
    public Article addArticle(Article article) {

        accountRepository.findById(article.getAccount().getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ACCOUNT));

        return articleRepository.save(article);
    }

//    public void modifyArticle(Article article){}

    @Transactional
    public void removeArticle(Long loginAccountId, Long articleId) {
        accountRepository.findById(loginAccountId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ACCOUNT));

        Article findArticle = articleRepository.findByIdWithAll(articleId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ARTICLE));

        verifyAccess(findArticle, loginAccountId);

//        commentRepository.deleteAll(findArticle.getComment());
//        recommendVoteRepository.deleteAll(findArticle.getRecommendVote());
        articleRepository.delete(findArticle);
    }

    public Article findArticle(Long articleId) {
        return articleRepository.findByIdWithAll(articleId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ARTICLE));
    }

    public Page<Article> findArticles(String keyword, Pageable pageable) {
        return articleRepository.searchByTitleWithAll(keyword, pageable);
    }

    public Page<Article> findAccountArticles(Long accountId, Pageable pageable) {
        return articleRepository.findByAccountWithAll(accountId, pageable);
    }

    @Transactional
    public String voteArticle(RecommendArticle recommendArticle) {

        verifyArticleVoteField(recommendArticle);

        Long accountId = recommendArticle.getAccount().getId();
        Long articleId = recommendArticle.getArticle().getId();
        Optional<RecommendArticle> findOptionalArticleVote =
                recommendVoteRepository.findByArticleAndAccount(accountId, articleId);

        if(findOptionalArticleVote.isEmpty()) {
            recommendVoteRepository.save(recommendArticle);
            return "success vote";
        }

        RecommendArticle findArticleVote = findOptionalArticleVote.get();

        if(recommendArticle.getState().equals(findArticleVote.getState())) {
            recommendVoteRepository.delete(findArticleVote);
            return "cancel vote";
        } else {
            throw new BusinessLogicException(ExceptionCode.ILLEGAL_VOTE);
        }
    }

    private void verifyArticleVoteField(RecommendArticle recommendArticle) {
        accountRepository.findById(recommendArticle.getAccount().getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ACCOUNT));

        articleRepository.findById(recommendArticle.getArticle().getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ARTICLE));
    }


    private void verifyAccess(Article article, Long accountId) {
        if(!accountId.equals(article.getAccount().getId())) {
            throw new BusinessLogicException(ExceptionCode.NON_ACCESS_MODIFY);
        }
    }
}
