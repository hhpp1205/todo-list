package list.todo.todolist.domain.task.controller;

import list.todo.todolist.domain.task.dto.TaskResponse;
import list.todo.todolist.domain.task.dto.TaskRequestDto;
import list.todo.todolist.domain.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    @PostMapping
    public TaskResponse create(@RequestBody @Validated TaskRequestDto taskRequestDto) {
        return taskService.create(taskRequestDto.toEntity());
    }

    @PutMapping("/{taskId}")
    public TaskResponse update(@RequestBody @Validated TaskRequestDto taskRequestDto,
                               @PathVariable Long taskId) {
        return taskService.update(taskId, taskRequestDto.toEntity());
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }

    @PutMapping("/{taskId}/done")
    public TaskResponse done(@PathVariable Long taskId) {
        return taskService.done(taskId);
    }

}
