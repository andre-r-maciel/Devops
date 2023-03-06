package br.com.cwi.crescer.tcc.security.service;

import br.com.cwi.crescer.tcc.security.controller.response.UsuarioListadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.mapper.UsuarioListadoMapper;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuariosPorNomeOuEmailService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public Page<UsuarioListadoResponse> procurar(String texto, Pageable pageable) {

        return usuarioRepository.findByNomeContainsIgnoreCaseOrEmailContainsIgnoreCase(texto, texto, pageable)
                .map(UsuarioListadoMapper::toResponse);
    }

    public Page<UsuarioListadoResponse> procurarAmigos(String texto, Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        return usuarioRepository.findAmigos(usuario.getId(), texto, texto, pageable)
                .map(UsuarioListadoMapper::toResponse);
    }
}
