import { axiosInstance } from '../_base/axiosInstance.api'
import { API_URL } from '../../constants'

export async function logout() {
  await axiosInstance.post(`${API_URL}/logout`, {})
}
