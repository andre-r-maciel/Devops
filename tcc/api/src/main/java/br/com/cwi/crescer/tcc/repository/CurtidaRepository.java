package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    Curtida findByPostIdAndUsuarioId(Long postId, Long usuarioId);

    int countByPostId(Long id);
}
