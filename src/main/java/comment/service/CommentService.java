package comment.service;

import account.entity.Account;
import account.repository.AccountRepository;
import article.entity.Article;
import article.repository.ArticleRepository;
import comment.dto.CommentReqDto;
import comment.entity.Comment;
import comment.mapper.CommentRequestMapper;
import comment.repository.CommentRepository;
import global.advice.BusinessLogicException;
import global.exceptionCode.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final AccountRepository accountRepository;
    private final ArticleRepository articleRepository;
    private final CommentRequestMapper commentRequestMapper;

    @Transactional
    public Comment insert(Long articleId, CommentReqDto commentReqDto) {

        Account account = accountRepository.findById(commentReqDto.getAccountId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ACCOUNT));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_ARTICLE));

        Comment comment = commentRequestMapper.toEntity(commentReqDto);

        Comment parentComment;
        if(commentReqDto.getParentId() != null) {
            commentRepository.findById(commentReqDto.getParentId())
                    .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_COMMENT));

            comment.updateParent(comment);
        }
        comment.updateAccount(account);
        comment.updateArticle(article);

        return commentRepository.save(comment);
    }

    @Transactional
    public void delete(Long commentId) {
        Comment comment = commentRepository.findCommentByIdWithParent(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_COMMENT));

        if(comment.getChildren().size() != 0) {
            comment.changeIsDeleted(true);
        } else {
            commentRepository.delete(getDeletAbleAncestorComment(comment));
        }
    }

    private Comment getDeletAbleAncestorComment(Comment comment) {
        Comment parent = comment.getParent(); // 현재 댓글의 부모를 구한다
        if(parent != null && parent.getChildren().size() == 1 && parent.getIsDeleted())
            // 부모가 있고, 부모의 자식이 1개 ( 지금 삭제하는 댓글)이고, 부모의 삭제 상태가 TRUE인 댓글이라면 재귀
            return getDeletAbleAncestorComment(parent);
        return comment; // 삭제해야하는 댓글 반환
    }

    @Transactional
    public void update(Long commentId, CommentReqDto commentReqDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_COMMENT));
        comment.updateContent(commentReqDto.getContent());
    }
}
