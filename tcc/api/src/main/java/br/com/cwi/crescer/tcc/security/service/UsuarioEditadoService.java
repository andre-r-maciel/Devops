package br.com.cwi.crescer.tcc.security.service;

import br.com.cwi.crescer.tcc.security.controller.request.UsuarioEditadoRequest;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioEditadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.mapper.UsuarioEditadoMapper;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEditadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public UsuarioEditadoResponse editar(UsuarioEditadoRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setNome(request.getNome());
        usuario.setApelido(request.getApelido());
        usuario.setFotoPerfil(request.getFotoPerfil());

        usuarioRepository.save(usuario);

        return UsuarioEditadoMapper.toResponse(usuario);

    }
}
