import styles from "./Form.module.css";
import { getTodos, todos, categorias, editarUser } from "../service/api";
import { useState, useEffect } from "react";

function FormModal({ pessoa, setAbrirModal, carregarDados  }) {
  const [categories, setCategories] = useState([]);
  const [tarefaEdit, setTarefaEdit] = useState("");
  const [categoriaEdit, setCategoriaEdit] = useState("");
  const [dataEdit, setDataEdit] = useState("");
  const [dados, setDados] = useState([]);

  useEffect(() => {
    carregarDados();
    carregarCategorias();
    getAllTarefas();
  }, []);

  useEffect(() => {
    if (pessoa) {
      pessoaEdit();
      console.log("pessoa :>> ", pessoa.tarefa);
    }
  }, [pessoa]);

  const getAllTarefas = async () => {
    try {
      let allTarefas = await todos();
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

  function pessoaEdit() {
    setCategoriaEdit(pessoa.categoria?.nome);
    setDataEdit(pessoa.data);
    setTarefaEdit(pessoa.tarefa);
  }

  const montarObjeto = async () => {
    const selecionado = categories.find(cat => cat.nome === categoriaEdit)
    await editarUser(pessoa.id, {
      tarefa: tarefaEdit,
      categoria: selecionado,
      data: dataEdit,
    });
    carregarDados();
    setAbrirModal(false);
  };

  return (
    <>
      <div className={styles.divFrom}>
        <label>Tarefa</label>
        <input
          type="text"
          onChange={(e) => setTarefaEdit(e.target.value)}
          value={tarefaEdit}
        />

        <label>Categoria</label>
        <select
          name="select"
          onChange={(e) => setCategoriaEdit(e.target.value)}
          value={categoriaEdit}
        >
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
        <input
          type="date"
          onChange={(e) => setDataEdit(e.target.value)}
          value={dataEdit}
        />

          <div className={styles.btn_info}>
              <button
                className={styles.btn_fechar}
                onClick={() => {
                  setAbrirModal(false);
                }}
              >
                Fechar
              </button>

              <button
                className={styles.btn_salvar}
                onClick={() => {
                  montarObjeto();
                }}
              >
                Salvar
              </button>
            </div>
          </div>
    </>
  );
}

export default FormModal;
