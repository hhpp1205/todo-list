package list.todo.todolist.domain.task.model;

import list.todo.todolist.domain.member.model.Member;
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

    private LocalDate lastDoneDate; // 마지막으로 Do it 한 날짜

    /**
     * ED = Every Day(매일)
     * EW = Every Week(매주)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskType taskType;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Task(Long taskId, String title, Boolean isDone, LocalDate lastDoneDate, TaskType taskType, Member member) {
        this.taskId = taskId;
        this.title = title;
        this.isDone = isDone;
        this.lastDoneDate = lastDoneDate;
        this.taskType = taskType;
        this.member = member;
    }

    /**
     * 비즈니스 로직
     */

    public void update(Task updateRequest) {
        this.title = updateRequest.getTitle();
        this.taskType = updateRequest.getTaskType();
    }

    public void setMember(Member member) {
        this.member = member;
    }

   public void updateLastDoneDate(LocalDate updateDate) {
       this.lastDoneDate = updateDate;
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
