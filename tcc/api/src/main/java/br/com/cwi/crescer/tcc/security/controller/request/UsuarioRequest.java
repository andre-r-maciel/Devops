package br.com.cwi.crescer.tcc.security.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @Email
    @NotNull
    private String email;

    private String apelido;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotBlank
    private String senha;

    private String fotoPerfil;
}
