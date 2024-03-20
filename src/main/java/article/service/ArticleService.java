package article.service;

import account.entity.Account;
import account.repository.AccountRepository;
import article.dto.ArticleReqDto;
import article.entity.Article;
import article.mapper.ArticleReqMapper;
import article.repository.ArticleRepository;
import category.entity.Category;
import category.repository.CategoryRepository;
import comment.repository.CommentRepository;
import global.advice.BusinessLogicException;
import global.exceptionCode.ExceptionCode;
import global.exceptionCode.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.Lombok.checkNotNull;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AccountRepository accountRepository;
    private final ArticleReqMapper articleReqMapper;
    private final CommentRepository commentRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Article findById(Long id) {
        checkNotNull(id, "articleId must be provided");
        return articleRepository.findById(id).orElseThrow(() -> new NotFoundException("could not found article id : " + id));
    }

    @Transactional
    public Article addArticle(Article article) {

        accountRepository.findById(article.getAccount().getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ACCOUNT));

        return articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public Article insert(ArticleReqDto articleReqDto) {
        Account account = accountRepository.findById(articleReqDto.getAccountId())
                .orElseThrow(() -> new NotFoundException("Could not found account id : " + articleReqDto.getAccountId()));

        Article article = ArticleReqMapper.INSTANCE.toEntity(articleReqDto);
        article.updateAccount(account);

        return articleRepository.save(article);
    }

    @Transactional
    public Article update(ArticleReqDto articleReqDto, Long id) {
        Article article = findById(id);
        Category category = categoryRepository.findById(articleReqDto.getCateId())
                .orElseThrow(() -> new NotFoundException("Could not found category id : " + articleReqDto.getCateId()));

        return article.updateArticle(articleReqDto, category);
    }

    @Transactional
    public Article delete(long id) {
        Article article = findById(id);
        articleRepository.delete(article);
        return article;
    }

    private void verifyAccess(Article article, Long accountId) {
        if(!accountId.equals(article.getAccount().getId())) {
            throw new BusinessLogicException(ExceptionCode.NON_ACCESS_MODIFY);
        }
    }
}
