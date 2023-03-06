package br.com.cwi.crescer.tcc.mapper;

import br.com.cwi.crescer.tcc.controller.request.PostRequest;
import br.com.cwi.crescer.tcc.controller.response.PostResponse;
import br.com.cwi.crescer.tcc.domain.Post;

public class PostMapper {

    public static Post toEntity(PostRequest request) {
        Post post = new Post();
        post.setMensagem(request.getMensagem());
        post.setVisualizacao(request.getVisualizacao());
        return post;
    }

    public static PostResponse toResponse(Post post) {
        return PostResponse.builder()
                .mensagem(post.getMensagem())
                .visualizacao(post.getVisualizacao())
                .dataPostagem(post.getDataPostagem())
                .build();
    }
}
