package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.controller.response.SolicitacaoResponse;
import br.com.cwi.crescer.tcc.domain.Estado;
import br.com.cwi.crescer.tcc.mapper.ListarSolicitacaoMapper;
import br.com.cwi.crescer.tcc.repository.SolicitacaoRepository;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarSolicitacaoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public Page<SolicitacaoResponse> listar(Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        return solicitacaoRepository.findByUsuarioIdAndEstado(usuario.getId(), Estado.SOLICITADO, pageable)
                .map(ListarSolicitacaoMapper::toResponse);
    }
}
