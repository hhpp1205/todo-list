package list.todo.todolist.domain.task.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private Boolean isDone;



    @Builder
    public Task(Long taskId, String title, Boolean isDone) {
        this.taskId = taskId;
        this.title = title;
        this.isDone = isDone;

    }

    /**
     * 비즈니스 로직
     */

    public void update(Task updateRequest) {
        this.title = updateRequest.getTitle();
    }

   public void taskDone() {
       this.isDone = true;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return taskId.equals(task.taskId);
    }

    @Override
    public int hashCode() {
        return taskId.hashCode();
    }
}
