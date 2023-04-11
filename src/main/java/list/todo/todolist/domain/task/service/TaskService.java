package list.todo.todolist.domain.task.service;

import list.todo.todolist.domain.member.exception.MemberNotFoundException;
import list.todo.todolist.domain.member.model.Member;
import list.todo.todolist.domain.member.repository.MemberRepository;
import list.todo.todolist.domain.task.dto.TaskResponseDto;
import list.todo.todolist.domain.task.exception.TaskAccessDeniedException;
import list.todo.todolist.domain.task.exception.TaskNotFoundException;
import list.todo.todolist.domain.task.model.Task;
import list.todo.todolist.domain.task.repository.TaskRepository;
import list.todo.todolist.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final MemberRepository memberRepository;

    public TaskResponseDto create(Long memberId, Task task) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        task.setMember(member);
        taskRepository.save(task);

        return new TaskResponseDto(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone(),
                task.getLastDoneDate(),
                task.getTaskType());
    }

    public TaskResponseDto update(Long memberId, Long taskId, Task updateRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(ErrorCode.TASK_ACCESS_DENIED));

        if (member != task.getMember()) {
            throw new TaskAccessDeniedException(ErrorCode.TASK_ACCESS_DENIED);
        }

        task.update(updateRequest);

        return new TaskResponseDto(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone(),
                task.getLastDoneDate(),
                task.getTaskType());
    }

    public void delete(Long memberId, Long taskId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(ErrorCode.TASK_ACCESS_DENIED));

        if (member != task.getMember()) {
            throw new TaskAccessDeniedException(ErrorCode.TASK_ACCESS_DENIED);
        }

        taskRepository.deleteById(taskId);
    }

    public TaskResponseDto done(Long memberId, Long taskId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(ErrorCode.TASK_ACCESS_DENIED));

        if (member != task.getMember()) {
            throw new TaskAccessDeniedException(ErrorCode.TASK_ACCESS_DENIED);
        }

        task.updateLastDoneDate(LocalDate.now());

        return new TaskResponseDto(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone(),
                task.getLastDoneDate(),
                task.getTaskType());
    }

    public List<TaskResponseDto> findAll(Long memberId) {
        return taskRepository.findAll(memberId).stream()
                .map(t -> new TaskResponseDto(
                        t.getTaskId(),
                        t.getTitle(),
                        t.getIsDone(),
                        t.getLastDoneDate(),
                        t.getTaskType())).toList();
    }
}
