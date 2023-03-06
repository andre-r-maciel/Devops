package br.com.cwi.crescer.tcc.security.controller.response;

import lombok.*;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class UsuarioListadoResponse {

    private String nome;
    private String email;
    private String apelido;
    private String fotoPerfil;

}
