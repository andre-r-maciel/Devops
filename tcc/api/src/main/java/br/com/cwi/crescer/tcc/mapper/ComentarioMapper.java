package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.controller.request.ComentarioRequest;
import br.com.cwi.crescer.tcc.controller.response.ComentarioResponse;
import br.com.cwi.crescer.tcc.domain.Comentario;

public class ComentarioMapper {

    public static Comentario toEntity(ComentarioRequest request) {
        Comentario comentario = new Comentario();
        comentario.setResposta(request.getResposta());
        return comentario;
    }

    public static ComentarioResponse toResponse(Comentario comentario) {
        return ComentarioResponse.builder()
                .resposta(comentario.getResposta())
                .dataComentario(comentario.getDataComentario())
                .build();
    }
}
