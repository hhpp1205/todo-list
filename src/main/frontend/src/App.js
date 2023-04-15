import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Head from './global/head/Head';
import WiseSaying from './wisesaying/WiseSaying';
import Todolist from "./todolist/Todolist";


function App() {
  return (
    <div className="App">
        <Head />
        <WiseSaying/>
        <Todolist/>
    </div>
  );
}

export default App;
