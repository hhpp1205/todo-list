package list.todo.todolist.domain.task.dto;

import list.todo.todolist.domain.task.model.Task;
import list.todo.todolist.domain.task.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {
    @NotBlank
    private String title;

    /**
     * ED, EW
     */
    @NotBlank
    private String taskType;

    public Task toEntity() {
        TaskType type = TaskType.valueOf(taskType);

        if (type == null) {
            throw new IllegalArgumentException();
        }

        return Task.builder()
                .title(title)
                .taskType(type)
                .build();
    }
}
