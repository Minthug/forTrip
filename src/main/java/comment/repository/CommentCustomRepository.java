package comment.repository;

import comment.dto.CommentResDto;
import comment.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CommentCustomRepository {

    List<CommentResDto> findByArticleId(Long id);

    Optional<Comment> findCommentByIdWithParent(Long id);
}
