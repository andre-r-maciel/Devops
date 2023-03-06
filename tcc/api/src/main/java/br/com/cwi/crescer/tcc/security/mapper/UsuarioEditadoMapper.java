package br.com.cwi.crescer.tcc.security.mapper;

import br.com.cwi.crescer.tcc.security.controller.response.UsuarioEditadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;

public class UsuarioEditadoMapper {

    public static UsuarioEditadoResponse toResponse (Usuario usuario) {

        return UsuarioEditadoResponse.builder()
                .nome(usuario.getNome())
                .apelido(usuario.getApelido())
                .fotoPerfil(usuario.getFotoPerfil())
                .build();
    }
}
