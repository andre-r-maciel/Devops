import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function editarUsuario(nome, apelido, fotoPerfil) {
  const response = await axiosInstance.put(`${API_URL}/usuarios/me/editar`, {
    nome,
    apelido,
    fotoPerfil,
  })

  return response.data
}
