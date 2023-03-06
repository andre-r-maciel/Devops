package br.com.cwi.crescer.tcc.domain;

import br.com.cwi.crescer.tcc.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Curtida {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
