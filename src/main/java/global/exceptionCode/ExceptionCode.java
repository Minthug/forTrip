package global.exceptionCode;


import lombok.Getter;

public enum ExceptionCode {

    NOT_FOUND(404, "요청하신 데이터를 찾을 수 없습니다."),
    NOT_FOUND_ACCOUNT(400, "Account를 찾을 수 없습니다."),
    ACCOUNT_EXIST(400, "이미 회원가입된 Email입니다."),
    NOT_FOUND_ARTICLE(400, "Article을 찾을 수 없습니다."),
    NON_ACCESS_MODIFY(400, "수정 권한이 없습니다."),
    ILLEGAL_FILENAME(400, "잘못된 형식의 Filename 입니다."),
    NOT_FOUND_ANSWER(400, "Answer를 찾을 수 없습니다."),  // conflict난 부분 수정
    ILLEGAL_VOTE(400, "잘못된 Vote 요청입니다."),
    DUPLICATED_SELECT(400, "이미 채택된 Answer가 있습니다"),
    NOT_PROFILE_IMG(400, "회원가입 시 프로필 이미지가 필요합니다."),
    ACCESS_TOKEN_EXPIRATION(400, "로그인이 필요한 기능입니다."),
    LOGIN_FAILURE(401, "이메일, 비밀 번호가 틀렸습니다."),
    NOT_FOUND_COMMENT(400, "요청하신 댓글 데이터를 찾을 수 없습니다.");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
