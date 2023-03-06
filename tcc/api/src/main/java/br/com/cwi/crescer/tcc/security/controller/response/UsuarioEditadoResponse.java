package br.com.cwi.crescer.tcc.security.controller.response;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UsuarioEditadoResponse {

    private String nome;

    private String apelido;

    private String fotoPerfil;
}
