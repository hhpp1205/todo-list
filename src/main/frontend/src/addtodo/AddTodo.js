import React, {useState} from "react";
import './AddTodo.css'

const AddTodo = (props) =>  {
  const [title, setTitle] = useState("");

  return (
    <div id='addTodo'>
      <input
        type="text"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        onKeyDown={(e) => {
          props.enterKeyPress(e, title)
          if(e.key === 'Enter') {
            setTitle("");
          }
        }}
      />
      <button onClick={() => {
        props.addTodo(title);
        setTitle("");
      }}>할일 추가</button>
    </div>
  )
}

export default AddTodo;