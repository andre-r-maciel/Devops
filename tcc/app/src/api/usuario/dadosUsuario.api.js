import { API_URL } from '../../constants'
import { axiosInstance } from '../_base/axiosInstance.api'

export async function dadosUsuario() {
  const response = await axiosInstance.get(`${API_URL}/usuarios/me`, {})

  return response.data
}
