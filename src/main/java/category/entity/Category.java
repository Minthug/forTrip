package category.entity;

import auditing.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "category")
public class Category extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "categoryId")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public Category(Long id, String name) {
        this.name = name;
    }
}
