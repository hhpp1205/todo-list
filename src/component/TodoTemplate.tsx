import TodoInsert from "./TodoInsert";
import {useState} from "react";
import {ModalType, Todo} from "../types";
import TodoList from "./TodoList";
import styled from "styled-components";
import Modal from "./Modal";

const TemplateWrapper = styled.div`
    width: 100%;
    min-height: 100vh;
    background-color: ${({ theme }) => theme.bgColor};
    display: flex;
    justify-content: center;
    align-items: start;
    padding-top: 80px;
`;

const TemplateInner = styled.div`
  width: 400px;
  border-radius: 12px;
  overflow: hidden;
  background-color: ${({ theme }) => theme.bgColor};
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
`;

type TodoTemplateProps = {
    todos: Todo[];
    setTodos: (value: Todo[]) => void;
    modalType: ModalType;
    setModalType: (modalType: ModalType) => void;
};

const TodoTemplate = ( {todos, setTodos, modalType, setModalType}: TodoTemplateProps ) => {

    const [selectId, setSelectId] = useState<number | null>(null);

    const insertTodo = (text: string) => {
        const nextId = todos.length > 0 ? Math.max(...todos.map(todo => todo.id)) + 1 : 1;

        const newTodo: Todo = {
            id: nextId,
            text,
            checked: false,
        }

        setTodos([...todos, newTodo]);
    }

    const onToggle = (id: number) => {
        setTodos(
            todos.map(todo => {
                return todo.id === id ? {...todo, checked: !todo.checked} : todo
            })
        )
    }

    const onRemove = (id: number) =>  {
        setTodos(
            todos.filter(todo => todo.id !== id)
        )
    }

    const openDeleteModal = (id: number) => {
        setSelectId(id);
        setModalType("deleteOne");
    }

    const handleRemove = () => {
        if (selectId !== null) {
            onRemove(selectId);
            setModalType(null);
            setSelectId(null);
        }
    };

    return (
        <TemplateWrapper>
            <TemplateInner>
                {modalType === "deleteOne" && (
                    <Modal
                        onConfirm={handleRemove}
                        onCancel={() => setModalType(null)}
                        message="정말 삭제하시겠습니까?"
                    />
                )}
                <TodoInsert insertTodo={insertTodo} />
                <TodoList todos={todos} onToggle={onToggle} onRemove={openDeleteModal} />
            </TemplateInner>
        </TemplateWrapper>
    )
}

export default TodoTemplate;