package list.todo.todolist.domain.task.controller;

import list.todo.todolist.domain.task.dto.TaskResponseDto;
import list.todo.todolist.domain.task.dto.TaskRequestDto;
import list.todo.todolist.domain.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    @PostMapping
    public TaskResponseDto create(@RequestBody @Validated TaskRequestDto taskRequestDto) {
        return taskService.create(taskRequestDto.toEntity());
    }

    @PutMapping("/{taskId}")
    public TaskResponseDto update(@PathVariable Long taskId, @RequestBody @Validated TaskRequestDto taskRequestDto) {
        return taskService.update(taskId, taskRequestDto.toEntity());
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }

    @PutMapping("/{taskId}/done")
    public TaskResponseDto done(@PathVariable Long taskId) {
        return taskService.done(taskId);
    }

    @PutMapping("/{taskId}/cancel")
    public TaskResponseDto cancel(@PathVariable Long taskId) {
        return taskService.cancel(taskId);
    }

    @GetMapping
    public List<TaskResponseDto> findAll() {
        return taskService.findAll();
    }

}
