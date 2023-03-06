package br.com.cwi.crescer.tcc.security.repository;

import br.com.cwi.crescer.tcc.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findByNomeContainsIgnoreCaseOrEmailContainsIgnoreCase(String nome, String email, Pageable pageable);

    @Query(value = "select usu.* from usuario usu join amizade ami on (usu.id = ami.amigo_id) " +
            "where (ami.usuario_id :id) and (upper(usu.nome) like  upper('% [:nome] %') or upper(usu.email) " +
            "like upper('% [:email] %'))", nativeQuery = true)
    Page<Usuario> findAmigos(Long id, String nome, String email, Pageable pageable);
}
