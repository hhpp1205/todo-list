import {useState} from "react";
import styled from "styled-components";

type TodoInsertProps = {
    insertTodo: (text: string) => void;
};

const InsertForm = styled.div`
  display: flex;
  padding: 12px;
  background-color: ${({ theme }) => theme.bgColor};
`;

const Input = styled.input`
  flex: 1;
  padding: 10px;
  background-color: ${({ theme }) => theme.bgColor};
  color: ${({ theme }) => theme.textColor};
  font-size: 16px;
`;

const AddButton = styled.button`
  margin-left: 8px;
  padding: 10px 16px;
  background-color: ${({ theme }) => theme.textColor};
  color: ${({ theme }) => theme.bgColor};
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 18px;
`;

const TodoInsert = ({insertTodo}: TodoInsertProps) => {
    const [value, setValue] = useState<string>("");

    const handleSubmit = () => {
        insertTodo(value);
        setValue("");
    }

    return (
        <InsertForm>
            <Input
                value={value}
                onChange={(e) => setValue(e.target.value)}
                placeholder="할 일을 입력하세요"
            />
            <AddButton onClick={handleSubmit}>+</AddButton>
        </InsertForm>
    )
}

export default TodoInsert;