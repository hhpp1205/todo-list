import React, {useState} from "react";
import './todolist.css'
import AddTodo from "../addtodo/AddTodo";


const Todo = (props) => {
  const [isChecked, setIsChecked] = useState(props.todo.isDone);

  const handleToggle = () => {
    setIsChecked(!isChecked);
  };

  return(
    <div className='todo-item'>
      <input type='checkbox' checked={isChecked} onChange={() => handleToggle}/>
      <input type='text' value={props.todo.title}/>
      <button>수정</button>
      <button onClick={() => props.deleteTodo(props.todo.taskId)}>삭제</button>
    </div>
  );
}

const Todolist = () => {

  const [todos, setTodos] = useState([
      {taskId : 1, title : '오운완', isDone : true, lastDoneDate : null, taskType : 'ED'},
      {taskId : 2, title : '리액트 투두리스트 만들기', isDone : false, lastDoneDate : null, taskType : 'ED'},
      {taskId : 3, title : 'CS 공부', isDone : false, lastDoneDate : null, taskType : 'EW'}
  ]);

  const addTodo = (title) => {
    const newTodo = {
      taskId : todos.length + 1,
      title : title,
      isDone : false,
      lastDoneDate : null,
      taskType : null
    }

    setTodos([...todos, newTodo]);
  };

  const deleteTodo = (taskId) => {
    const newTodos = todos.filter((todo) => todo.taskId != taskId);
    setTodos(newTodos);
  }

  return (
    <div>
      <AddTodo addTodo={addTodo}/>
      {todos.map(
        todo => <Todo todo={todo} deleteTodo={deleteTodo}/>
      )}
    </div>
  );
}

export default Todolist;