package list.todo.todolist.domain.task.repository;

import list.todo.todolist.domain.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
}
