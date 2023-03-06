package br.com.cwi.crescer.tcc.security.service.core;

import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario porId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }

}
