package list.todo.todolist.domain.task.model;

import list.todo.todolist.domain.member.model.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    /**
     * ED = Every Day(매일)
     * EW = Every Week(매주)
     * OT = One Time(한번)
     */
    private TaskType taskType;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
