package br.com.cwi.crescer.tcc.controller;

import br.com.cwi.crescer.tcc.controller.response.ComentarioResponse;
import br.com.cwi.crescer.tcc.mapper.ComentarioMapper;
import br.com.cwi.crescer.tcc.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComentarioListadoService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Page<ComentarioResponse> listar(Long id, Pageable pageable) {

        return comentarioRepository.findByPostId(id, pageable)
                .map(ComentarioMapper::toResponse);
    }
}
