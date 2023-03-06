import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function buscarUsuario() {
  const response = await axiosInstance.get(`${API_URL}/usuarios/procurar`, {})

  return response.data
}
