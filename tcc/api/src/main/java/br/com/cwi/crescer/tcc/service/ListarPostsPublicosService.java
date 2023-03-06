package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.controller.response.PostResponse;
import br.com.cwi.crescer.tcc.domain.Visualizacao;
import br.com.cwi.crescer.tcc.mapper.PostMapper;
import br.com.cwi.crescer.tcc.security.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostsPublicosService {

    @Autowired
    private PostRepository postRepository;

    public Page<PostResponse> listar(Long id, Pageable pageable) {

        return postRepository.findByUsuarioIdAndVisualizacao(id, Visualizacao.PUBLICO, pageable)
                .map(PostMapper::toResponse);
    }

}
