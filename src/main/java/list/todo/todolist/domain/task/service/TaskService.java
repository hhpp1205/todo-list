package list.todo.todolist.domain.task.service;

import list.todo.todolist.domain.task.dto.TaskResponseDto;
import list.todo.todolist.domain.task.exception.TaskAccessDeniedException;
import list.todo.todolist.domain.task.exception.TaskNotFoundException;
import list.todo.todolist.domain.task.model.Task;
import list.todo.todolist.domain.task.repository.TaskRepository;
import list.todo.todolist.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponseDto create(Task task) {
        taskRepository.save(task);

        return new TaskResponseDto(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone());
    }

    public TaskResponseDto update(Long taskId, Task updateRequest) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(ErrorCode.TASK_ACCESS_DENIED));

        task.update(updateRequest);

        return new TaskResponseDto(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone());
    }

    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskResponseDto done(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(ErrorCode.TASK_ACCESS_DENIED));

        task.taskDone();

        return new TaskResponseDto(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone());
    }

    public List<TaskResponseDto> findAll() {
        return taskRepository.findAll().stream()
                .map(t -> new TaskResponseDto(
                        t.getTaskId(),
                        t.getTitle(),
                        t.getIsDone())).toList();
    }
}
