package list.todo.todolist.domain.member.dto;

import list.todo.todolist.domain.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private String email;
    private List<Task> taskList;
}
