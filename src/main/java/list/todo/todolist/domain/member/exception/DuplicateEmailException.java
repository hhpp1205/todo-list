package list.todo.todolist.domain.member.exception;

import list.todo.todolist.global.error.ErrorCode;
import list.todo.todolist.global.error.exception.BusinessException;

public class DuplicateEmailException extends BusinessException {

    public DuplicateEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
