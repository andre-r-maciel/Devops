import { createBrowserRouter, Navigate } from 'react-router-dom'
import { Buscar, Cadastro, Editar, Login, Perfil } from '../ui/screens'
import { PrivateRoute } from './privateRoute'

export const router = createBrowserRouter([
  {
    path: '/',
    element: <Navigate to="/login" />,
  },
  {
    path: '/login',
    element: <Login />,
  },
  {
    path: '/usuarios',
    element: <Cadastro />,
  },
  {
    path: '/perfil',
    element: <PrivateRoute Screen={Perfil} />,
  },
  {
    path: '/buscar',
    element: <PrivateRoute Screen={Buscar} />,
  },
  {
    path: '/editar',
    element: <PrivateRoute Screen={Editar} />,
  },
])
