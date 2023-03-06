package br.com.cwi.crescer.tcc.security.mapper;

import br.com.cwi.crescer.tcc.security.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;

public class UsuarioDetalhadoMapper {

    public static UsuarioDetalhadoResponse toResponse(Usuario usuario) {
        return UsuarioDetalhadoResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .fotoPerfil(usuario.getFotoPerfil())
                .assombracao(usuario.isAssombracao())
                .ativo(usuario.isAtivo())
                .build();
    }
}
