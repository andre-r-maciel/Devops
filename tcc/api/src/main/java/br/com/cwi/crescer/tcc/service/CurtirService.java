package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.tcc.security.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    public void curtir(Long id) {

        Usuario usuario = usuarioAutenticadoService.get();
        Post post = buscarPostService.porId(id);
        Curtida curtida = new Curtida();

        curtida.setUsuario(usuario);
        curtida.setPost(post);

        usuario.getCurtidas().add(curtida);
        post.getCurtidas().add(curtida);

        curtidaRepository.save(curtida);
    }
}
