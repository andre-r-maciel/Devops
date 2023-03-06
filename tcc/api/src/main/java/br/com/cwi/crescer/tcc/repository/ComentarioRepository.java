package br.com.cwi.crescer.tcc.repository;

import br.com.cwi.crescer.tcc.domain.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    Page<Comentario> findByPostId(Long id, Pageable pageable);

}
