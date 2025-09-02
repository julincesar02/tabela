import { useState, useEffect } from "react";
import styles from "./Modal.module.css";
import Form from "./Form";
import { categorias, editarUser, getTodos } from "../service/api";

function Modal({ pessoa, abrirModal, setAbrirModal, carregarDados }) {
  const [tarefaEdit, setTarefaEdit] = useState("");
  const [categoriaEdit, setCategoriaEdit] = useState("");
  const [dataEdit, setDataEdit] = useState("");
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    carregarCategorias();
  }, []);

  useEffect(() => {
    if (pessoa) {
      pessoaEdit();
    }
  }, [pessoa]);

  function pessoaEdit() {
    setCategoriaEdit(pessoa.categoria?.nome);
    setDataEdit(pessoa.data);
    setTarefaEdit(pessoa.tarefa);
  }

  async function carregarCategorias() {
    try {
      const pegarDados = await categorias();
      setCategories(pegarDados);
    } catch (error) {
      console.log("Deu ruim - carregarCategorias", error);
    }
  }

  const montarObjeto = async () => {
    setCategoriaEdit("oieee")
    await editarUser(pessoa.id, {
      tarefa: tarefaEdit,
      categoria: {
        id: index,
        nome: "categoriaEdit"
      },
      data: dataEdit,
    });
    carregarDados();
    setAbrirModal(false);
  };

  return (
    <div className={styles.div_modal}>
      {abrirModal && (
        <div className={styles.modal_edit}>
          <div className={styles.modal_cont}>
            <h2 className={styles.title}>Editar Tarefa</h2>
            <div className={styles.divFormulario}>
              <Form
                onChangeTarefa={(e) => {
                  setTarefaEdit(e.target.value);
                }}
                onChangeData={(e) => {
                  setDataEdit(e.target.value);
                }}
                onChangeCategoria={(e) => {
                  setCategoriaEdit(e.target.value);
                }}
                options={categories}
                categoria={categoriaEdit}
                valueData={dataEdit}
                valueTarefa={tarefaEdit}
              />
            </div>

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
        </div>
      )}
    </div>
  );
}

export default Modal;
