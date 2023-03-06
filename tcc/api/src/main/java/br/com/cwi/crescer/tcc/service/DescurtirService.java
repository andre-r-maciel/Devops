package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.PostRepository;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.tcc.security.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescurtirService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostRepository postRepository;

    public void descurtir(Long id) {

        Usuario usuario = usuarioAutenticadoService.get();
        Post post = buscarPostService.porId(id);
        Curtida curtida = curtidaRepository.findByPostIdAndUsuarioId(id, usuario.getId());

        usuario.removerCurtida(curtida);
        post.removerCurtida(curtida);

        curtidaRepository.delete(curtida);

        usuarioRepository.save(usuario);
        postRepository.save(post);
    }
}
