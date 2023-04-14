import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Head from './global/head/Head';
import WiseSaying from './wisesaying/WiseSaying';
import Todolist from "./todolist/Todolist";


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
        <Head />
        <WiseSaying/>
        <Todolist/>
    </div>
  );
}

export default App;
