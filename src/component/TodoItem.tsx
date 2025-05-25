import { Todo } from "../types";

type TodoProps = {
    todoItem: Todo;
    onToggle: (id: number) => void;
    onRemove: (id: number) => void;
};

const TodoItem = ({todoItem, onToggle, onRemove}: TodoProps) => {
    return (
        <div>
            <input type={"checkbox"} checked={todoItem.checked} onChange={() => onToggle(todoItem.id)}/>
            <span style={{textDecoration: todoItem.checked ? 'line-through' : 'none'}}>
                {todoItem.text}
            </span>
            <button onClick={() => onRemove(todoItem.id)}>삭제</button>
        </div>
    )
}

export default TodoItem;