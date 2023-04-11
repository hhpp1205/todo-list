package list.todo.todolist.domain.member.service;

import list.todo.todolist.domain.member.dto.MemberResponse;
import list.todo.todolist.domain.member.exception.DuplicateEmailException;
import list.todo.todolist.domain.member.exception.LoginFailedException;
import list.todo.todolist.domain.member.exception.MemberNotFoundException;
import list.todo.todolist.domain.member.model.Member;
import list.todo.todolist.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    public Long create(Member member) {
        exitEmail(member.getEmail());

        String password = encoder.encode(member.getPassword());
        member.setEnCodedPassword(password);

        return memberRepository.save(member).getMemberId();
    }

    public MemberResponse login(Member member) {
        Member loginMember = memberRepository.findByEmail(member.getEmail())
                .orElseThrow(() -> new MemberNotFoundException());

        if(!encoder.matches(member.getPassword(), loginMember.getPassword())) {
            throw new LoginFailedException();
        }

        return new MemberResponse(loginMember.getMemberId(), loginMember.getEmail(), loginMember.getTaskList());
    }

    private void exitEmail(String email) {
        if(memberRepository.existsByEmail(email)) {
            throw new DuplicateEmailException();
        }
    }
}
