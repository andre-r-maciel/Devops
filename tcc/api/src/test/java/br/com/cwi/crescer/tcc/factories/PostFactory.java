package br.com.cwi.crescer.tcc.factories;

import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.domain.Visualizacao;

public class PostFactory {

    public static Post getPublico() {

        Post post = new Post();
        post.setMensagem("Teste");
        post.setVisualizacao(Visualizacao.PUBLICO);
        return post;
    }
}
