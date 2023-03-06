package br.com.cwi.crescer.tcc.controller.response;

import br.com.cwi.crescer.tcc.domain.Visualizacao;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PostResponse {

    private String mensagem;
    private Visualizacao visualizacao;
    private LocalDateTime dataPostagem;
}
