package br.com.cwi.crescer.tcc.security.mapper;

import br.com.cwi.crescer.tcc.security.controller.response.UsuarioListadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;

public class UsuarioListadoMapper {

    public static UsuarioListadoResponse toResponse(Usuario usuario) {

        return UsuarioListadoResponse.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .fotoPerfil(usuario.getFotoPerfil())
                .build();
    }
}
