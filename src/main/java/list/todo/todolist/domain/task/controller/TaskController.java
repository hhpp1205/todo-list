package list.todo.todolist.domain.task.controller;

import list.todo.todolist.domain.task.dto.TaskResponse;
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
    public TaskResponse create(@SessionAttribute("member") Long memberId,
                               @RequestBody @Validated TaskRequestDto taskRequestDto) {
        return taskService.create(memberId, taskRequestDto.toEntity());
    }

    @PutMapping("/{taskId}")
    public TaskResponse update(@SessionAttribute("member") Long memberId,
                               @PathVariable Long taskId,
                               @RequestBody @Validated TaskRequestDto taskRequestDto) {
        return taskService.update(memberId, taskId, taskRequestDto.toEntity());
    }

    @DeleteMapping("/{taskId}")
    public void delete(@SessionAttribute("member") Long memberId,
                       @PathVariable Long taskId) {
        taskService.delete(memberId, taskId);
    }

    @PutMapping("/{taskId}/done")
    public TaskResponse done(@SessionAttribute("member") Long memberId,
                             @PathVariable Long taskId) {
        return taskService.done(memberId, taskId);
    }

    @GetMapping
    public List<TaskResponse> findAll(@SessionAttribute("member") Long memberId) {
        return taskService.findAll(memberId);
    }

}
