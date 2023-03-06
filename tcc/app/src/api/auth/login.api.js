import { axiosInstance } from '../_base/axiosInstance.api'
import { API_URL } from '../../constants'

export async function login({ username, password }) {
  const response = await axiosInstance.post(
    `${API_URL}/login`,
    {},
    {
      auth: {
        username: username,
        password: password,
      },
    }
  )

  return response.data
}
