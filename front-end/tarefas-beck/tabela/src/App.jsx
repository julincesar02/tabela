import { useEffect, useState } from "react";
import Form from "./componentes/Form";
import { categorias, tarefaUsers, getTodos, todos } from "./service/api";
import styles from "./App.module.css";
import Tabela from "./componentes/Tabela";
// import { BiTask } from "react-icons/bi";
// import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'

function App() {
  const [statusString, setStatusString] = useState("");
  const [todasTarefas, setTodasTarefas] = useState();
  const [dados, setDados] = useState([]);

  useEffect(() => {
    getAllTarefas();
    carregarDados()
    setStatusString("TODOS");
  }, []);

  const getAllTarefas = async () => {
    try {
      let allTarefas = await todos();
      setTodasTarefas(allTarefas);
      console.log("todasTarefas :>> ", allTarefas);
    } catch (error) {
      console.log("Deu ruim - getAllTarefas", error);
    }
  };

  async function carregarDados() {
    try {
      const pegarDados = await getTodos();
      setDados(pegarDados);
      setStatusString("TODOS");
      console.log(dados);
    } catch (error) {
      console.log("error :>> ", error);
    }
  }


  return (
    <>
      {/* <Router>
        <div className="App">
          <Routes>
            <Route path="/" element={<Login/>}></Route>
            
          </Routes>
        </div>
      </Router> */}

      <div className={styles.divFormulario}>
        <Form />s
      </div>

      <div className={styles.divTable}>
        <div className={styles.select}>
          <select
            onChange={(e) => {
              setStatusString(e.target.value);
            }}
            value={statusString}
            className={styles.select}
          >
            {todasTarefas?.map((op) => {
              return (
                <option required value={op} key={op}>
                  {op}
                </option>
              );
            })}
          </select>
        </div>
        {/* switch case */}

        {statusString === "TODOS" ? (
          <Tabela dados={dados} carregarTodosDados={() => carregarDados()} />
        ) : (
          <Tabela
            dados={dados.filter((tar) => tar.status === statusString)}
            carregarTodosDados={() => carregarDados()}
          />
        )}
      </div>
    </>
  );
}

export default App;
