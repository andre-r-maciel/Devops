import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function incluirUsuario({
  nome,
  email,
  apelido,
  dataNascimento,
  senha,
  fotoPerfil,
}) {
  const response = await axiosInstance.post(`${API_URL}/usuarios`, {
    nome,
    email,
    apelido,
    dataNascimento,
    senha,
    fotoPerfil,
  })

  return response.data
}
