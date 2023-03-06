package br.com.cwi.crescer.tcc.security.controller.response;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class UsuarioDetalhadoResponse {

    private Long id;

    private String nome;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    private String fotoPerfil;

    private boolean assombracao;

    private boolean ativo;
}
