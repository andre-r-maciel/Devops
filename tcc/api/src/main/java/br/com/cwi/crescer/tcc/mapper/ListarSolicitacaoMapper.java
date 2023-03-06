package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.controller.response.SolicitacaoResponse;
import br.com.cwi.crescer.tcc.domain.Solicitacao;

public class ListarSolicitacaoMapper {

    public static SolicitacaoResponse toResponse(Solicitacao solicitacao) {
        return SolicitacaoResponse.builder()
                .amigoId(solicitacao.getAmigoId())
                .estado(solicitacao.getEstado())
                .build();
    }

}
