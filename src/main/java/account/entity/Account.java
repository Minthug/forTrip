package account.entity;

import account.dto.AccountUpdateDto;
import article.entity.Article;
import auditing.BaseTime;
import comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "account")
public class Account extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickName", nullable = false)
    private String nickname;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "password", nullable = false)
    private String password;

    private String country; // 스크롤 선택?

    @Column(name = "emailCode")
    private String emailCode;

    @Column(name = "emailVerified")
    private Boolean emailVerified;

    @Enumerated(EnumType.STRING)
    @Column(name = "accountRole")
    private AccountRole role;

//    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
//    private List<Article> articleList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "comment")
//    private List<Comment> commentList = new ArrayList<>();


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


    public Account hashPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }


    public Account updateAccount(AccountUpdateDto accountUpdateDto, PasswordEncoder passwordEncoder) {
        this.nickname = accountUpdateDto.getNickname();
        this.password = passwordEncoder.encode(accountUpdateDto.getPassword());
        return this;
    }

    public boolean isValidEmailCode(String code) {
        return this.emailCode.equals(code);
    }

    public void completeSignUp() {
        this.emailVerified = true;
    }
}
