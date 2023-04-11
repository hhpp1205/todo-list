package list.todo.todolist.domain.task.service;

import list.todo.todolist.domain.task.dto.TaskResponse;
import list.todo.todolist.domain.task.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    public TaskResponse create(Task task) {
        // TODO: 2023/04/11
        return null;
    }

    public TaskResponse update(Long taskId, Task task) {
        // TODO: 2023/04/11  
        return null;
    }

    public void delete(Long taskId) {
        // TODO: 2023/04/11  
    }

    public TaskResponse done(Long taskId) {
        // TODO: 2023/04/11
        return null;
    }
}
