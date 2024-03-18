package reaction.service;

import account.entity.Account;
import account.repository.AccountRepository;
import article.entity.Article;
import article.repository.ArticleRepository;
import global.exceptionCode.DuplicateResourceException;
import global.exceptionCode.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reaction.dto.ReactionReqDto;
import reaction.entity.Reaction;
import reaction.repository.ReactionRepository;

@Service
@RequiredArgsConstructor
public class ReactionService {

    private final ReactionRepository reactionRepository;
    private final AccountRepository accountRepository;
    private final ArticleRepository articleRepository;

   @Transactional
   public void inset(ReactionReqDto reactionReqDto) throws Exception {

       Account account = accountRepository.findById(reactionReqDto.getAccountId())
               .orElseThrow(() -> new NotFoundException("Could not found Account id : " + reactionReqDto.getAccountId()));

       Article article = articleRepository.findById(reactionReqDto.getArticleId())
               .orElseThrow(() -> new NotFoundException("Could not found Article id : " + reactionReqDto.getArticleId()));

       if(reactionRepository.findByAccountAndArticle(account, article).isPresent()) {
           throw new DuplicateResourceException("already exist data by Account id : " + account.getId() + " ,"
                   + "article id : " + article.getId());
       }

       Reaction reaction = Reaction.builder()
               .article(article)
               .account(account)
               .build();

       reactionRepository.save(reaction);
//       articleRepository.addReactionCount(article);

   }
}
