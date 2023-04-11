package list.todo.todolist.domain.task.exception;

import list.todo.todolist.global.error.ErrorCode;
import list.todo.todolist.global.error.exception.BusinessException;

public class TaskNotFoundException extends BusinessException {
    public TaskNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
