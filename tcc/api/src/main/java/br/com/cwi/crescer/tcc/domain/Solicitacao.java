package br.com.cwi.crescer.tcc.domain;

import br.com.cwi.crescer.tcc.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long amigoId;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
