import styles from "./Form.module.css";
import {  getTodos, todos, categorias, tarefaUsers } from "../service/api"
import { useState, useEffect } from "react";

function Form({
  // options,
  // onChangeTarefa,
  // onChangeCategoria,
  // onChangeData,
  // categoria,
  // valueTarefa,
  // valueData,
}) {
  const [categories, setCategories] = useState([]);
  const [dados, setDados] = useState([]);
  const [tarefa, setTarefa] = useState("");
  const [data, setData] = useState("");
  const [categoria, setCategoria] = useState("");

  useEffect(() => {
    carregarDados();
    carregarCategorias();
    getAllTarefas();
  }, []);

  async function carregarDados() {
    try {
      const pegarDados = await getTodos();
      setDados(pegarDados);
      console.log(dados);
    } catch (error) {
      console.log("error :>> ", error);
    }
  }

  const getAllTarefas = async () => {
    try {
      let allTarefas = await todos();
      setTodasTarefas(allTarefas);
      console.log("todasTarefas :>> ", allTarefas);
    } catch (error) {
      console.log("Deu ruim - getAllTarefas", error);
    }
  };

  async function carregarCategorias() {
    try {
      const pegarDados = await categorias();
      setCategories(pegarDados);
      console.log("categories :>> ", categories);
    } catch (error) {
      console.log("Deu ruim - carregarCategorias", error);
    }
  }

  async function enviar() {
    if (data === "" || tarefa == "" || categoria === "") {
      alert("Preencha todos os campos antes de continuar!");
    } else {
      await tarefaUsers({
        tarefa: tarefa,
        data: data,
        categoria: {
          id: categoria.id,
          nome: "trabalho",
        },
        status: "PENDENTE",
      });
    }
    carregarDados();
    setCategoria("");
    setTarefa("");
    setData("");
  }

  return (
    <>
      <div className={styles.divFrom}>
        <label>Tarefa</label>
        <input type="text" onChange={(e) => setTarefa(e.target.value)} value={tarefa} />

        <label>Categoria</label>
        <select name="select" onChange={(e) => setCategoria(e.target.value)} value={categoria}>
          <option value="" disabled hidden>
            Selecione uma opção
          </option>

          {categories?.map((op) => {
            return (
              <option value={op.nome} key={op.id}>
                {op.nome}
              </option>
            );
          })}
        </select>

        <label>Data de conclusão:</label>
        <input type="date" onChange={(e) => setData(e.target.value)} value={data} />

          <button
          className={styles.btn_add}
          onClick={() => {
            enviar()
            console.log(categories)
          }}
        >
          Adicionar
        </button>
      </div>
    </>
  );
}

export default Form;
