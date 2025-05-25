import React, {useState} from 'react';
import './App.css';
import styled, {ThemeProvider} from "styled-components";
import {darkTheme, lightTheme} from "./style/theme";
import {GlobalStyle} from "./style/GlobalStyle";
import TodoTemplate from "./component/TodoTemplate";
import Modal from "./component/Modal";
import {ModalType, Todo} from "./types";

const ButtonWrapper = styled.div`
  position: absolute;
  top: 10px;
  right: 30px;
  display: flex;
  flex-direction: column;
  gap: 10px;
`;

const Button = styled.button`
  width: 100px;
  height: 50px;
`;

const dummyTodos: Todo[] = [
    {
        id: 1,
        text: "리액트 공부하기",
        checked: false,
    },
    {
        id: 2,
        text: "타입스크립트 연습하기",
        checked: true,
    },
    {
        id: 3,
        text: "점심 먹기",
        checked: false,
    },
    {
        id: 4,
        text: "운동 30분 하기",
        checked: true,
    },
];

function App() {
  const [theme, setTheme] = useState("dark");
  const [modalType, setModalType] = useState<ModalType>(null);
  const [todos, setTodos] = useState<Todo[]>(dummyTodos);
  const isLight = theme === "light";

  const toggleTheme = () => {
    if (theme === "light") {
      setTheme("dark");
    } else {
      setTheme("light");
    }
  }

  const openAllDeleteModal = () => {
      setModalType("deleteAll");
  }

  const handleRemoveAll = () => {
      setTodos([]);
      setModalType(null);
  }

  return (
      <ThemeProvider theme={isLight ? lightTheme : darkTheme}>
          <GlobalStyle />
          <TodoTemplate
              todos={todos}
              setTodos={setTodos}
              modalType={modalType}
              setModalType={setModalType}
          />
          {modalType === "deleteAll" && (
              <Modal
                  onConfirm={handleRemoveAll}
                  onCancel={() => setModalType(null)}
                  message="할 일을 모두 삭제하시겠습니까?"
              />
          )}
          <ButtonWrapper>
              <Button onClick={toggleTheme}>
                  {isLight ? "Dark 🌚" : "Light 🌝"}
              </Button>
              <Button onClick={openAllDeleteModal}>
                  할 일 모두 삭제
              </Button>
          </ButtonWrapper>
      </ThemeProvider>
  )

}

export default App;
