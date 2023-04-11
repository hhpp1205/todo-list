package list.todo.todolist.domain.member.dto;

import list.todo.todolist.domain.member.model.Member;
import list.todo.todolist.domain.member.model.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    @Email
    private String email;

    @NotBlank
    private String password;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .roleType(RoleType.USER)
                .build();
    }
}
