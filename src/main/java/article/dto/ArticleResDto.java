package article.dto;

import auditing.BaseTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import comment.dto.CommentResDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleResDto extends BaseTime {

    private Long id;
    private String title;
    private String content;
    private String hashTag;
    private Integer reactionCount;
    private Integer commentCount;

    private Boolean isSecret;
    private List<CommentResDto> commentResDtos;

    @Builder
    public ArticleResDto(Long id, String title, String content, String hashTag, Integer reactionCount, Integer commentCount, Boolean isSecret, List<CommentResDto> commentResDtos) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hashTag = hashTag;
        this.reactionCount = reactionCount;
        this.commentCount = commentCount;
        this.isSecret = isSecret;
        this.commentResDtos = commentResDtos;
    }
}
