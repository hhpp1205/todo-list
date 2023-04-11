package list.todo.todolist.domain.member.service;

import list.todo.todolist.domain.member.dto.MemberResponse;
import list.todo.todolist.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    public Long create(Member member) {
        // TODO: 2023/04/11
        return null;
    }

    public MemberResponse login(Member member) {
        // TODO: 2023/04/11
        // 세션에 Member 저장
        return null;
    }
}
