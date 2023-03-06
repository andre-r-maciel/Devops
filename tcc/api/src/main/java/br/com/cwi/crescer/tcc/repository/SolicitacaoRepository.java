package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Estado;
import br.com.cwi.crescer.tcc.domain.Solicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    Page<Solicitacao> findByUsuarioIdAndEstado(Long id, Estado estado, Pageable pageable);

    Solicitacao findByUsuarioIdAndAmigoId(Long usuarioId, Long amigoId);
}
