import React, {useEffect, useState} from "react";
import './todolist.css'
import AddTodo from "../addtodo/AddTodo";


const Todo = (props) => {
  const [isChecked, setIsChecked] = useState(props.todo.isDone);
  const [isEditing, setIsEditing] = useState(false);
  const [title, setTitle] = useState(props.todo.title);

  useEffect(() => {
    const inputElement = document.getElementById(`input${props.todo.taskId}`);
    if(inputElement) {
      inputElement.disabled = !isEditing;
    }
  }, [isEditing, props.todo.taskId]);


  const handleToggle = () => {
    setIsChecked(!isChecked);
  };

  const toggleEditing = () => {
    setIsEditing(!isEditing);
  };

  return(
    <div className='todo-item'>
      <input type='checkbox' checked={isChecked} onChange={handleToggle} />
      <input
        id={`input${props.todo.taskId}`}
        className={`todo-item ${!isChecked ? 'none' : 'line-through'} ${isEditing ? 'todo-input-enable' : 'todo-input-disable'}`}
        type='text'
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        disabled={!isEditing}
      />
      <button onClick={() => toggleEditing()}>{isEditing ? "완료" : "수정"}</button>
      <button onClick={() => props.deleteTodo(props.todo.taskId)}>삭제</button>
    </div>
  );
}

const Todolist = () => {

  const [todos, setTodos] = useState([]);

  useEffect(() => {
     fetch('http://localhost:8080/api/v1/tasks')
      .then(response => response.json())
      .then(data => {
        setTodos(data);
      })
    },[]);

  const addTodo = (title) => {
    if(!title) {
      return;
    }
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

  const updateTodo = ({todo}) => {
    const newTodo = {
      taskId : todo.taskId,
      title : todo.title,
      isDone : todo.isDone,
      lastDoneDate : todo.lastDoneDate,
      taskType : todo.taskType
    }

    setTodos([...todos, newTodo])
  }

  return (
    <div>
      <AddTodo addTodo={addTodo}/>
      {todos.map(
        todo => <Todo key={todo.taskId} todo={todo} deleteTodo={deleteTodo}/>
      )}
    </div>
  );
}

export default Todolist;