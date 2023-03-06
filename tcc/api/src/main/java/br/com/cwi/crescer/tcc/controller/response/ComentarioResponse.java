package br.com.cwi.crescer.tcc.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ComentarioResponse {

    private String resposta;

    private LocalDateTime dataComentario;

}
