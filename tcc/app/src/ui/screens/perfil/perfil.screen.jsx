import './perfil.style.css'
import useGlobalUser from "../../../context/user.context"
import { dadosUsuario } from '../../../api/usuario/dadosUsuario.api'
import { useState, useEffect } from "react";

export function Perfil() {

    const [user, setUser] = useGlobalUser()

    async function getUser() {
        const fullUser = await dadosUsuario()
        setUser(fullUser.data)
    }

    useEffect(() => {
        getUser()
    }, [])

    return 
        <div className='userInfos'>
            <img src={user.fotoPerfil} alt={`foto de perfil de ${user.nome}`}/>
            <h1>{user.apelido ? user.apelido : user.nome}</h1>
        </div>
    
}