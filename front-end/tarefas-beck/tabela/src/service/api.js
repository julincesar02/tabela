import axios from "axios";

const api = axios.create({
  baseURL: "http://10.0.1.71:8080",
});

export async function categorias() {
  const categorias = await api.get("/categorias");
  console.log("categorias :>> ", categorias.data);
  return categorias.data;
}

export async function getTodos() {
  const response = await api.get("/todos");
  return response.data;
}

export async function tarefaUsers(obj) {
  const dados = await api.post("/todos", obj);
  console.log('dados :>> ', dados.data);
  return dados.data;
}

export async function deleteUser(id) {
  await api.delete(`/todos/${id}`);
}

export async function editarUser(id, newUser) {
  await api.patch(`/todos/editar/${id}`, newUser);
}

export async function todos() {
  const resposta = await api.get("/status");
  return resposta.data;
}

export async function atualizarStatus(id) {
  await api.patch(`/todos/${id}`, { status: "CONCLUIDO" });
}

export async function atualizarStatusPend(id) {
  await api.patch(`/todos/${id}`, { status: "PENDENTE" });
}
