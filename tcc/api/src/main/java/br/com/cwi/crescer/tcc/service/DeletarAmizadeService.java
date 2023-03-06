package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.tcc.security.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeletarAmizadeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void deletar(Long id) {
        Usuario usuario = usuarioAutenticadoService.get();
        Usuario amigo = buscarUsuarioService.porId(id);

        usuario.removerAmigo(amigo);

        usuarioRepository.save(usuario);
        usuarioRepository.save(amigo);
    }

}
