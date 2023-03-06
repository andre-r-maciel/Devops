package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.controller.request.PostRequest;
import br.com.cwi.crescer.tcc.controller.response.PostResponse;
import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.mapper.PostMapper;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.PostRepository;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.tcc.security.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    private NowService nowService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public PostResponse postar(PostRequest request) {

        Post post = PostMapper.toEntity(request);
        Usuario usuario = usuarioAutenticadoService.get();

        post.setDataPostagem(nowService.getDate());
        post.setUsuario(usuario);

        usuario.getPosts().add(post);

        postRepository.save(post);

        return PostMapper.toResponse(post);
    }

}
