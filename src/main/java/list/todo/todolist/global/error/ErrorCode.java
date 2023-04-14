package list.todo.todolist.global.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //Common
    INVALID_INPUT_VALUE(400, "C001", "잘못된 입력입니다."),

    //Member
    DUPLICATE_EMAIL(400, "M001", "중복된 이메일입니다."),
    LOGIN_FAILED(400, "M002", "로그인에 실패하였습니다."),
    MEMBER_NOT_FOUND(204, "M003", "사용자를 찾을 수 없습니다."),

    //Task
    TASK_ACCESS_DENIED(403, "T001", "접근 할 수 없는 Task입니다."),
    TASK_NOT_FOUND(204, "T002", "Task를 찾을 수 없습니다.");



    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
