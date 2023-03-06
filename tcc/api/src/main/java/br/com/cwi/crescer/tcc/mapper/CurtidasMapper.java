package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.controller.response.CurtidaResponse;

public class CurtidasMapper {

    public static CurtidaResponse toResponse(int totalCurtidas) {
        return CurtidaResponse.builder()
                .totalCurtidas(totalCurtidas)
                .build();
    }
}
