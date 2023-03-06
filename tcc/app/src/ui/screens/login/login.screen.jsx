import './login.style.css'
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../../../api/auth/login.api";
import { logout } from '../../../api/auth/logout.api'
import useGlobalUser from "../../../context/user.context";
import { dadosUsuario } from '../../../api/usuario/dadosUsuario.api';

export function Login() {
  const [formInput, setFormInput] = useState({ email: "", password: "" });
  const navigate = useNavigate();
  const [user, setUser] = useGlobalUser();
  const [error, setError] = useState();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
  
    try {
      
      const user = await login({
        username: formInput.email,
        password: formInput.password,
      });

      setUser(user.data)
    } catch (error) {
      setError("Usuário ou senha incorretos")
    }
  }

  function onClick() {
    navigate("/usuarios");
  }

  async function callLogout() {
    await logout()
  }

  useEffect(() => {
    if(user) {
      navigate("/perfil")
    }
  }, [handleSubmit])

  return (
    <>
      <header>
        <h1>Assombrados</h1>
        <button className='buttonCriarConta' onClick={onClick}>Criar conta</button>
      </header>
      <div className='divForm'>
        <form action="" onSubmit={handleSubmit}>
          <label>Email:</label>
          <input
            required
            value={formInput.email}
            name="email"
            onChange={handleChange}
          />
          <label>Senha:</label>
          <input
            required
            type="password"
            value={formInput.password}
            name="password"
            onChange={handleChange}
          />
          <button type='submit'>Login</button>
        </form>
        {error ? <p>{error}</p> : null}
      </div>
    </>
  )
}
