package list.todo.todolist.domain.task.repository;

import list.todo.todolist.domain.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Task WHERE member_id = :memberId")
    List<Task> findAll(@Param("memberId") Long memberId);
}
