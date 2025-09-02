import { useState, useEffect } from "react";
import styles from "./Modal.module.css";
import Form from "./Form";
import { categorias, editarUser, getTodos } from "../service/api";
import FormModal from "./FormModal";

function Modal({ pessoa, abrirModal, setAbrirModal, carregarDados }) {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    carregarCategorias();
  }, []);

  async function carregarCategorias() {
    try {
      const pegarDados = await categorias();
      setCategories(pegarDados);
    } catch (error) {
      console.log("Deu ruim - carregarCategorias", error);
    }
  }

  return (
    <div className={styles.div_modal}>
      {abrirModal && (
        <div className={styles.modal_edit}>
          <div className={styles.modal_cont}>
            <h2 className={styles.title}>Editar Tarefa</h2>
            <div className={styles.divFormulario}>
              <FormModal
                pessoa={pessoa}
                setAbrirModal={setAbrirModal}
                carregarDados={carregarDados}
              />
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default Modal;
