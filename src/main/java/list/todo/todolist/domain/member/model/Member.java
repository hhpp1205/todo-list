package list.todo.todolist.domain.member.model;

import list.todo.todolist.domain.task.model.Task;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 50, unique = true, nullable = false, updatable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    @OneToMany(mappedBy = "member")
    private List<Task> taskList = new ArrayList<>();

    @Builder
    public Member(Long memberId, String email, String password, RoleType roleType, List<Task> taskList) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.roleType = roleType;
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return memberId.equals(member.memberId);
    }

    @Override
    public int hashCode() {
        return memberId.hashCode();
    }
}
