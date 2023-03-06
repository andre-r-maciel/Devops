package br.com.cwi.crescer.tcc.controller.request;

import br.com.cwi.crescer.tcc.domain.Visualizacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class PostRequest {

    @NotBlank
    private String mensagem;

    @NotNull
    private Visualizacao visualizacao;
}
