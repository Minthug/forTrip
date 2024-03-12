package comment.dto;


import account.dto.ArticleAccountResDto;
import comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResDto {

    private Long id;
    private String content;
    private ArticleAccountResDto account;
    private List<CommentResDto> children = new ArrayList<>();

    public CommentResDto(Long id, String content, ArticleAccountResDto account) {
        this.id = id;
        this.content = content;
        this.account = account;
    }

    public static CommentResDto convertCommentToDto(Comment comment) {
        return comment.getIsDeleted() ?
                new CommentResDto(comment.getId(), "This comment has been deleted", null) :
                new CommentResDto(comment.getId(), comment.getContent(), new ArticleAccountResDto(comment.getAccount()));
    }
}
