package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.controller.response.CurtidaResponse;
import br.com.cwi.crescer.tcc.mapper.CurtidasMapper;
import br.com.cwi.crescer.tcc.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContarCurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    public CurtidaResponse contar(Long id) {
        int totalCurtidas = curtidaRepository.countByPostId(id);
        return CurtidasMapper.toResponse(totalCurtidas);
    }

}
