package list.todo.todolist.domain.task.service;

import list.todo.todolist.domain.member.exception.MemberNotFoundException;
import list.todo.todolist.domain.member.model.Member;
import list.todo.todolist.domain.member.repository.MemberRepository;
import list.todo.todolist.domain.task.dto.TaskResponse;
import list.todo.todolist.domain.task.exception.TaskAccessDeniedException;
import list.todo.todolist.domain.task.exception.TaskNotFoundException;
import list.todo.todolist.domain.task.model.Task;
import list.todo.todolist.domain.task.repository.TaskRepository;
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

    public TaskResponse create(Long memberId, Task task) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException());

        task.setMember(member);
        taskRepository.save(task);

        return new TaskResponse(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone(),
                task.getLastDoneDate(),
                task.getTaskType());
    }

    public TaskResponse update(Long memberId, Long taskId, Task updateRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException());

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException());

        if (member != task.getMember()) {
            throw new TaskAccessDeniedException();
        }

        task.update(updateRequest);

        return new TaskResponse(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone(),
                task.getLastDoneDate(),
                task.getTaskType());
    }

    public void delete(Long memberId, Long taskId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException());

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException());

        if (member != task.getMember()) {
            throw new TaskAccessDeniedException();
        }

        taskRepository.deleteById(taskId);
    }

    public TaskResponse done(Long memberId, Long taskId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException());

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException());

        if (member != task.getMember()) {
            throw new TaskAccessDeniedException();
        }

        task.updateLastDoneDate(LocalDate.now());

        return new TaskResponse(
                task.getTaskId(),
                task.getTitle(),
                task.getIsDone(),
                task.getLastDoneDate(),
                task.getTaskType());
    }

    public List<TaskResponse> findAll(Long memberId) {
        return taskRepository.findAll(memberId).stream()
                .map(t -> new TaskResponse(
                        t.getTaskId(),
                        t.getTitle(),
                        t.getIsDone(),
                        t.getLastDoneDate(),
                        t.getTaskType())).toList();
    }
}
