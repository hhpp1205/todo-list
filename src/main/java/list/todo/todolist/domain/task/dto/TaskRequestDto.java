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

    private String title;

    /**
     * ED, EW
     */
    private String taskType;

    public Task toEntity() {
        return Task.builder()
                .title(title)
                .isDone(false)
                .build();
    }
}
