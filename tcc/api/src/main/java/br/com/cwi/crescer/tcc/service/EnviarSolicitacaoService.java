package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.domain.Estado;
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
public class EnviarSolicitacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public void enviar(Long id) {

        Usuario usuario = usuarioAutenticadoService.get();
        Usuario amigo = buscarUsuarioService.porId(id);

        Solicitacao enviada = Solicitacao.builder()
                .amigoId(amigo.getId())
                .estado(Estado.AGUARDANDO)
                .usuario(usuario)
                .build();

        Solicitacao recebida = Solicitacao.builder()
                .amigoId(usuario.getId())
                .estado(Estado.SOLICITADO)
                .usuario(amigo)
                .build();

        usuario.solicitarAmizade(enviada);
        amigo.receberSolicitacao(recebida);

        solicitacaoRepository.save(enviada);
        solicitacaoRepository.save(recebida);
        usuarioRepository.save(usuario);
        usuarioRepository.save(amigo);
    }
}
