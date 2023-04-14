import React, {useState} from "react";

const AddTodo = ({addTodo}) =>  {
  const [title, setTitle] = useState("");

  return (
    <div>
      <input type="text" value={title} onChange={(e) => setTitle(e.target.value)}/>
      <button onClick={() => addTodo(title)}>할일 추가</button>
    </div>
  )
}

export default AddTodo;