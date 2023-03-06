import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function selecionarAmigo(id) {
  const response = await axiosInstance.get(
    `${API_URL}/usuarios/me/solicitacoes/${id}`,
    {}
  )

  return response.data
}
