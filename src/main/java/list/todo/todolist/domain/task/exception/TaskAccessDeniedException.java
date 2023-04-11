package list.todo.todolist.domain.task.exception;

import list.todo.todolist.global.error.ErrorCode;
import list.todo.todolist.global.error.exception.BusinessException;

public class TaskAccessDeniedException extends BusinessException {
    public TaskAccessDeniedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
