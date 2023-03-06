package br.com.cwi.crescer.tcc.domain;

import br.com.cwi.crescer.tcc.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensagem;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Visualizacao visualizacao;

    @Column(nullable = false)
    private LocalDateTime dataPostagem;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Curtida> curtidas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void removerCurtida(Curtida curtida) {
        this.getCurtidas().remove(curtida);
    }
}
