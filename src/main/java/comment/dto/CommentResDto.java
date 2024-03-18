package comment.dto;


import account.dto.AccountDto;
import account.dto.ArticleAccountResDto;
import comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResDto {

    private Long id;
    private String content;
    private AccountDto account;
    private List<CommentResDto> children = new ArrayList<>();

    public CommentResDto(Long id, String content, AccountDto account) {
        this.id = id;
        this.content = content;
        this.account = account;
    }

    public static CommentResDto convertCommentToDto(Comment comment) {
        return comment.getIsDeleted() ?
                new CommentResDto(comment.getId(), "This comment has been deleted", null) :
                new CommentResDto(comment.getId(), comment.getContent(), new AccountDto(comment.getAccount()));
    }
}
