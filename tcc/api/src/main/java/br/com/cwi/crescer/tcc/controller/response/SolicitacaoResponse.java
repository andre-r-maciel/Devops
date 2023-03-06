package br.com.cwi.crescer.tcc.controller.response;

import br.com.cwi.crescer.tcc.domain.Estado;
import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class SolicitacaoResponse {

    private Long amigoId;
    private Estado estado;
}
