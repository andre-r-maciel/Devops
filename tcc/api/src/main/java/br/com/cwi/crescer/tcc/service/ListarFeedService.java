package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.controller.response.PostResponse;
import br.com.cwi.crescer.tcc.mapper.PostMapper;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.PostRepository;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarFeedService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;


    public Page<PostResponse> listar(Pageable pageable) {
        Usuario usuario = usuarioAutenticadoService.get();

       return postRepository.listFeedUsuario(usuario.getId(), usuario.getId(), pageable)
               .map(PostMapper::toResponse);
    }
}
