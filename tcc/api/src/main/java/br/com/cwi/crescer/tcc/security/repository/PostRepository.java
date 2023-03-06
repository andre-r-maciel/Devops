package br.com.cwi.crescer.tcc.security.repository;

import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.domain.Visualizacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select po.* from post po join amizade a on (po.usuario_id = a.amigo_id) " +
            "where a.usuario_id = :id union select pos.* from post pos where pos.usuario_id = :mesmaId",
            nativeQuery = true)
   Page<Post> listFeedUsuario(Long id, Long mesmaId, Pageable pageable);

    @Query(value = "select pos.* from post pos where pos.usuario_id = :id", nativeQuery = true)
    Page<Post> listarPostsUsuario(Long id, Pageable pageable);

    Page<Post> findByUsuarioIdAndVisualizacao(Long id, Visualizacao visualizacao, Pageable pageable);
}
