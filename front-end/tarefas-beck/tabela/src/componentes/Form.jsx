import styles from "./Form.module.css";

function Form({
  options,
  onChangeTarefa,
  onChangeCategoria,
  onChangeData,
  categoria,
  valueTarefa,
  valueData,
}) {
  return (
    <>
      <div className={styles.divFrom}>
        <label>Tarefa</label>
        <input type="text" onChange={onChangeTarefa} value={valueTarefa} />

        <label>Categoria</label>
        <select name="select" onChange={onChangeCategoria} value={categoria}>
          <option value="" disabled hidden>
            Selecione uma opção
          </option>

          {options?.map((op) => {
            return (
              <option value={op.nome} key={op.id}>
                {op.nome}
              </option>
            );
          })}
        </select>

        <label>Data de conclusão:</label>
        <input type="date" onChange={onChangeData} value={valueData} />
      </div>
    </>
  );
}

export default Form;
