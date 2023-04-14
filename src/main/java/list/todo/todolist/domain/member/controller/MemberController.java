package list.todo.todolist.domain.member.controller;

import list.todo.todolist.domain.member.dto.MemberResponse;
import list.todo.todolist.domain.member.dto.SignInDto;
import list.todo.todolist.domain.member.dto.SignUpDto;
import list.todo.todolist.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long create(@RequestBody @Validated SignUpDto signUpDto) {
        return memberService.create(signUpDto.toEntity());
    }

    @PostMapping("/login")
    public MemberResponse login(@RequestBody @Validated SignInDto signInDto, HttpSession session) {
        MemberResponse response = memberService.login(signInDto.toEntity());

        session.setAttribute("member", response.getMemberId());

        return response;
    }

    @DeleteMapping("/logout")
    public void logout(@SessionAttribute("member") Long memberId, HttpSession session) {
        if (memberId != null) session.removeAttribute("member");
    }
}
