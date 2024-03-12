package article.entity;

import auditing.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tag")
public class HashTag extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "tagId")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public HashTag(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
