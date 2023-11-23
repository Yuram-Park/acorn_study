import React, {useState} from 'react';
import Todos from './components/Todos';
import Todo from './utils/todos';
import InsertTodo from './components/InsertTodo';

function App() {

  // 할 일
  //const todos = [new Todo("공부하기"), new Todo("청소하기")]
  const [todos, setTodos] = useState<Todo[]>([]);
  const addTodoHandler = (item:string) => {
    const newTodo = new Todo(item);
    setTodos((prevTodos)=>{
      return [...prevTodos, newTodo]
    })
  }

  const removeTodoHandler = (id:string) => {
    console.log("id:" +id);
    setTodos((prevTodos)=>prevTodos.filter((todo)=>todo.id !== id));
  }

  return (
    <div className="App">
      <InsertTodo onAddTodo={addTodoHandler}/>
      <hr/>
      <Todos items={todos} onRemoveTodo={removeTodoHandler}/>
    </div>
  );
}

export default App;
