import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Head from './global/head/Head';
import WiseSaying from './wisesaying/WiseSaying';
import Todolist from "./todolist/Todolist";
import AddTodo from "./addtodo/AddTodo";

function App() {


  // const [isLogin, setIsLogin] = useState(false);
  // const successLogin = () =>  {
  //   setIsLogin(true);
  // }
  // const loginPageHandler = () => {
  //   return isLogin ? [<WiseSaying />, <Todolist />] : <Login isLogin={isLogin} successLogin={successLogin}/>
  // }

  return (
    <div className="App">
      <header className="App-header">
        <Head />
        <WiseSaying/>
        <Todolist/>
      </header>
    </div>
  );
}

export default App;
