package list.todo.todolist.domain.member.exception;

import list.todo.todolist.global.error.ErrorCode;
import list.todo.todolist.global.error.exception.BusinessException;

public class MemberNotFoundException extends BusinessException {
    public MemberNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
