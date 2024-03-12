package comment.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentReqDto {

    private Long accountId;
    private Long parentId;
    private String content;

    public CommentReqDto(String content) {
        this.content = content;
    }
}
