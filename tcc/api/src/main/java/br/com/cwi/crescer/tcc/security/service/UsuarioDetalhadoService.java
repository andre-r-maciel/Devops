package br.com.cwi.crescer.tcc.security.service;

import br.com.cwi.crescer.tcc.security.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalhadoService {

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public UsuarioDetalhadoResponse detalhar(Long id) {

        Usuario usuario = buscarUsuarioService.porId(id);

        return UsuarioDetalhadoMapper.toResponse(usuario);
    }
}
