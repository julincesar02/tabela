import { useEffect, useState } from "react";
import Form from "./componentes/Form";
import { categorias, tarefaUsers, getTodos, todos } from "./service/api";
import styles from "./App.module.css";
import Tabela from "./componentes/Tabela";
// import { BiTask } from "react-icons/bi";
// import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'

function App() {
  const [categories, setCategories] = useState([]);
  const [dados, setDados] = useState([]);
  const [tarefa, setTarefa] = useState("");
  const [data, setData] = useState("");
  const [categoria, setCategoria] = useState("");
  const [statusString, setStatusString] = useState("");
  const [todasTarefas, setTodasTarefas] = useState();

  useEffect(() => {
    carregarDados();
    carregarCategorias();
    getAllTarefas();
  }, []);

  async function carregarDados() {
    try {
      const pegarDados = await getTodos();
      setDados(pegarDados);
      setStatusString("TODOS");
      console.log(dados)
    } catch (error) {
      console.log("error :>> ", error);
    }
  }

  const getAllTarefas = async () => {
    try {
      let allTarefas = await todos();
      setTodasTarefas(allTarefas);
    } catch (error) {
      console.log("Deu ruim - getAllTarefas", error);
    }
  };

  async function carregarCategorias() {
    try {
      const pegarDados = await categorias();
      setCategories(pegarDados);
    } catch (error) {
      console.log("Deu ruim - carregarCategorias", error);
    }
  }

  async function enviar() {
    if (data === "" || data == "") {
      alert("Preencha todos os campos antes de continuar!");
    } else {
      await tarefaUsers({
        tarefa: tarefa,
        data: data,
        categoria: {
          id: 1, 
          nome: "trabalho"
        },
        status: "PENDENTE"
      });
    }
    carregarDados();
    setCategoria("");
    setTarefa("");
    setData("");
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
        <Form
          options={categories}
          onChangeTarefa={(e) => {
            setTarefa(e.target.value);
          }}
          onChangeData={(e) => {
            setData(e.target.value);
          }}
          onChangeCategoria={(e) => {
            setCategoria(e.target.value);
          }}
          categoria={categoria}
          valueTarefa={tarefa}
          valueData={data}
        />

        <button
          className={styles.btn_add}
          onClick={() => {
            enviar();
          }}
        >
          Adicionar
        </button>
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
