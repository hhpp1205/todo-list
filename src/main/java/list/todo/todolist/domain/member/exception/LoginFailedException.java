package list.todo.todolist.domain.member.exception;

import list.todo.todolist.global.error.ErrorCode;
import list.todo.todolist.global.error.exception.BusinessException;

public class LoginFailedException extends BusinessException {

    public LoginFailedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
