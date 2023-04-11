package list.todo.todolist.domain.task.dto;

import list.todo.todolist.domain.task.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    private Long taskId;
    private String title;
    private Boolean isDone;
    private LocalDate lastDoneDate;
    private TaskType taskType;

}
