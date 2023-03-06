package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.security.mapper.UsuarioListadoMapper;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioListadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAmigosService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public Page<UsuarioListadoResponse> listar(Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        List<UsuarioListadoResponse> listaAmigos = usuario.getAmigos().stream()
                .map(UsuarioListadoMapper::toResponse)
                .collect(Collectors.toList());

        return new PageImpl<UsuarioListadoResponse>(listaAmigos, pageable, listaAmigos.size());
    }
}
