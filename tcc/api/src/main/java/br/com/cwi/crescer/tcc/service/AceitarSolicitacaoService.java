package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Solicitacao;
import br.com.cwi.crescer.tcc.repository.SolicitacaoRepository;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.repository.UsuarioRepository;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.tcc.security.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AceitarSolicitacaoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void aceitar (Long id) {
        Usuario usuario = usuarioAutenticadoService.get();
        Usuario amigo = buscarUsuarioService.porId(id);

        Solicitacao solicitacao = solicitacaoRepository.findByUsuarioIdAndAmigoId(usuario.getId(), id);
        Solicitacao solicitacaoReversa = solicitacaoRepository.findByUsuarioIdAndAmigoId(id, usuario.getId());

        usuario.adicionarAmigo(amigo);

        usuario.removerSolicitacao(solicitacao);
        amigo.removerSolicitacao(solicitacaoReversa);

        solicitacaoRepository.delete(solicitacao);
        solicitacaoRepository.delete(solicitacaoReversa);

        usuarioRepository.save(usuario);
        usuarioRepository.save(amigo);

    }
}
