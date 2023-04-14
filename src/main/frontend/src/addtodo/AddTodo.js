import React, {useState} from "react";
import './AddTodo.css'

const AddTodo = ({addTodo}) =>  {
  const [title, setTitle] = useState("");

  return (
    <div id='addTodo'>
      <input type="text" value={title} onChange={(e) => setTitle(e.target.value)}/>
      <button onClick={() => {
        addTodo(title);
        setTitle("");
      }}>할일 추가</button>
    </div>
  )
}

export default AddTodo;