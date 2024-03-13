package account.entity;

import account.dto.AccountUpdateDto;
import article.entity.Article;
import auditing.BaseTime;
import comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Account extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountId")
    private Long id;
    @Column(unique = true)
    private String email;
    private String nickname;
    private int age;
    private String password;
    private String country; // 스크롤 선택?
    private LocalDateTime createDay;

    @Column(name = "emailCode")
    private String emailCode;

    @Column(name = "emailVerified")
    private Boolean emailVerified;

    @Enumerated(EnumType.STRING)
    @Column(name = "accountRole")
    private AccountRole role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Article> articleList = new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    private List<Comment> commentList = new ArrayList<>();

    /*
    * 이름
    * 나이
    * 페스워드
    * 지역(나라)
    * 이메일
    * 가입일자
    * */

    @Builder
    public Account(Long id, String email, String nickname, int age, String password, String country, AccountRole role) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.password = password;
        this.country = country;
        this.emailCode = UUID.randomUUID().toString();
        this.emailVerified = false;
        this.role = role;
        this.role = role == null ? AccountRole.ROLE_USER : role;
    }

    public Account updateAccount(AccountUpdateDto accountUpdateDto) {
        this.nickname = accountUpdateDto.getNickname();
        this.password = accountUpdateDto.getPassword();
        return this;
    }

    public boolean isValidEmailCode(String code) {
        return this.emailCode.equals(code);
    }

    public void completeSignUp() {
        this.emailVerified = true;
    }
}
