import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function removerAmizade(id) {
  await axiosInstance.delete(`${API_URL}/usuarios/me/solicitacao/${id}`, {})
}
