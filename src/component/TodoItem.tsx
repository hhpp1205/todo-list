import { Todo } from "../types";

type TodoProps = {
    todoObject: Todo;
    onToggle: (id: number) => void;
    onRemove: (id: number) => void;
};

const TodoObject = ({todoObject, onToggle, onRemove}: TodoProps) => {
    return (
        <div>
            <input type={"checkbox"} checked={todoObject.checked} onChange={() => onToggle(todoObject.id)}/>
            <span style={{textDecoration: todoObject.checked ? 'line-through' : 'none'}}>
                {todoObject.text}
            </span>
            <button onClick={() => onRemove(todoObject.id)}>삭제</button>
        </div>
    )
}

export default TodoObject;