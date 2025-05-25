import TodoItem from "./TodoItem";
import { Todo } from "../types";
import styled from "styled-components";
import Modal from "./Modal";

type TodoListProps = {
    todos: Todo[];
    onToggle: (id: number) => void;
    onRemove: (id: number) => void;
}

const ListWrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 8px;
  padding: 12px;
  background-color: ${({ theme }) => theme.bgColor};
`;

const EmptyMessage = styled.p`
  color: ${({ theme }) => theme.textColor};
  text-align: center;
  margin: 32px 0;
  font-size: 14px;
`;

const TodoList = ({todos, onToggle, onRemove}: TodoListProps) => {

    function test() {
        return;
    }

    return (
        <ListWrapper>
            {todos.length === 0 ? (
                <EmptyMessage>할 일이 없습니다.</EmptyMessage>
            ) : (
                todos.map((todo) => (
                    <TodoItem
                        key={todo.id}
                        todoItem={todo}
                        onToggle={onToggle}
                        onRemove={onRemove}
                    />
                ))
            )}
        </ListWrapper>
    );
}

export default TodoList;