import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function enviarSolicitacao(id) {
  await axiosInstance.post(`${API_URL}/usuarios/me/solicitacao/${id}`, {})
}
