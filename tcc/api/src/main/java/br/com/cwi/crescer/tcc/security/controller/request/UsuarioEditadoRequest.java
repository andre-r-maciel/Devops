package br.com.cwi.crescer.tcc.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class UsuarioEditadoRequest {

    @NotBlank
    private String nome;

    private String apelido;

    private String fotoPerfil;

}
