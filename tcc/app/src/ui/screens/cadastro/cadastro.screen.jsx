import './cadastro.style.css'
import { login } from "../../../api/auth/login.api";
import { incluirUsuario } from "../../../api/auth/incluirUsuario.api";
import { useEffect, useState } from "react";
import useGlobalUser from "../../../context/user.context";
import { useNavigate } from "react-router";

export function Cadastro() {

    const [formInput, setFormInput] = useState({
        nome: "",
        email: "",
        apelido: "",
        dataNascimento: "",
        senha: "",
        fotoPerfil: "",
      });
      const [error, setError] = useState();
      const [user, setUser] = useGlobalUser();
      const navigate = useNavigate();
    
      function handleChange(event) {
        const { name, value } = event.target;
        setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
      }
    
      async function handleSubmit(event) {
        event.preventDefault();
        
        try {
          const createdUser = await incluirUsuario({
            nome: formInput.nome,
            email: formInput.email,
            apelido: formInput.apelido,
            dataNascimento: formInput.dataNascimento,
            senha: formInput.senha,
            fotoPerfil: formInput.fotoPerfil,
          });
    
          setUser(createdUser);

        } catch (error) {
          
            setError("email já utilizado"); 
          
        } finally {
          const loggedUser = await login({
            username: formInput.email,
            password: formInput.senha,
          });
    
          setUser(loggedUser);
        }
      }
    
      function onClick() {
        navigate("/login")
      }
    
      useEffect(() => {
        if(user) {
          navigate("/perfil")
        }
      }, [user, navigate]);
    
      return (
        <>
          <header>
            <h1>Cadastre-se</h1>
            <button onClick={onClick}>Voltar</button>
          </header>
          <div className='divForm'>
                <form className="formCreateUser" onSubmit={handleSubmit}>
                  <label className="formLabel">Nome:</label>
                  <input
                    required
                    className="formInput"
                    name="nome"
                    autoComplete="off"
                    value={formInput.nome}
                    onChange={handleChange}
                  />

                  <label className="formLabel">Email:</label>
                  <input
                    required
                    className="formInput"
                    name="email"
                    autoComplete="off"
                    value={formInput.email}
                    onChange={handleChange}
                    type='email'
                  />

                  <label className="formLabel">Apelido:</label>
                  <input
                    className="formInput"
                    name="apelido"
                    autoComplete="off"
                    value={formInput.apelido}
                    onChange={handleChange}
                  />

                  <label className="formLabel">Data de nascimento:</label>
                  <input
                    required
                    className="formInput"
                    name="dataNascimento"
                    autoComplete="off"
                    value={formInput.dataNascimento}
                    onChange={handleChange}
                    type='date'
                    max='2011-01-01'
                  />
      
                  <label className="formLabel">Senha:</label>
                  <input
                    required
                    className="formInput"
                    name="senha"
                    autoComplete="off"
                    value={formInput.senha}
                    onChange={handleChange}
                    type="password"
                  />

                  <label className="formLabel">Foto de perfil:</label>
                  <input
                    className="formInput"
                    name="fotoPerfil"
                    autoComplete="off"
                    value={formInput.fotoPerfil}
                    onChange={handleChange}
                  />
      
                  {error && <p className="form-error">{error}</p>}
      
                  <button className="formButton">Criar usuário</button>
                </form>
          </div>
        </>

      );
}