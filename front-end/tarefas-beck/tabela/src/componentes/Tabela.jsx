import { useState, useEffect } from "react";
import styles from "./Tabela.module.css";
import { CiEdit } from "react-icons/ci";
import { MdOutlineDeleteOutline } from "react-icons/md";
import {
  atualizarStatus,
  atualizarStatusPend,
  deleteUser,
} from "../service/api";
import Modal from "./Modal";

function Tabela({ dados, carregarTodosDados }) {
  const [abrirModal, setAbrirModal] = useState(false);
  const [pessoaEdit, setPessoaEdit] = useState();

  useEffect(() => {
   carregarTodosDados()
  }, []);

  useEffect(() => {
    console.log("dados :>> ", dados);
  }, [dados]);

  function modal() {
    setAbrirModal(true);
  }

  function editar(pessoa, index) {
    setAbrirModal(true);
    setPessoaEdit(pessoa);
  }

  async function tabelaFiltrado(e, id, tarefa) {
    if (tarefa.status === "PENDENTE") {
      await atualizarStatus(id);
    } else {
      await atualizarStatusPend(id);
    }
    carregarTodosDados();
  }

  async function apagarDados(id) {
    await deleteUser(id)
    carregarTodosDados()
  }

  return (
    <div>
      <Modal
        abrirModal={abrirModal}
        setAbrirModal={setAbrirModal}
        pessoa={pessoaEdit}
        carregarDados={() => carregarTodosDados()}
        
      />

      <div className={styles.divTabela}>
        <table className={styles.table}>
          <thead>
            <tr className={styles.thead}>
              <th>Concluir</th>
              <th>Tarefa</th>
              <th>Categoria</th>
              <th>Data</th>
              <th>Status</th>
              <th>Editar</th>
              <th>Apagar</th>
            </tr>
          </thead>

          <tbody>
            {dados?.map((tarefas, index) => (
              <tr key={index}>
                <td>
                  <input
                    type="checkbox"
                    checked={tarefas.status === "CONCLUIDO"}
                    onChange={(e) => {
                      tabelaFiltrado(e, tarefas.id, tarefas);
                      console.log(tarefas.id)
                      carregarTodosDados()
                    }}
                  />
                 
                </td>
                <td>{tarefas.tarefa}</td>
                <td>{tarefas?.categoria?.nome}</td>
                <td>{tarefas.data}</td>
                <td
                  className={
                    tarefas.status === "PENDENTE"
                      ? styles.statusPendente
                      : styles.statusConcluido
                  }
                >
                  {tarefas.status}
                </td>

                <td>
                  <button
                    className={styles.btnEdit}
                    onClick={() => {
                      editar(tarefas, index);
                      modal();
                    }}
                  >
                    {<CiEdit />}
                  </button>
                </td>
                <td>
                  <button
                    className={styles.btnEdit}
                    onClick={() => {
                      apagarDados(tarefas.id)
                    }}
                  >
                    {<MdOutlineDeleteOutline />}
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default Tabela;
