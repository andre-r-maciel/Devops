package br.com.cwi.crescer.tcc.security.domain;

import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Curtida;
import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.domain.Solicitacao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String apelido;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String fotoPerfil;

    @Column(nullable = true)
    private boolean assombracao;

    @Column(nullable = false)
    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Solicitacao> solicitacoes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "amizade",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "amigo_id"))
    private List<Usuario> amigos = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void solicitarAmizade(Solicitacao solicitacao) {
        this.getSolicitacoes().add(solicitacao);
    }

    public void receberSolicitacao(Solicitacao solicitacao) {
        this.getSolicitacoes().add(solicitacao);
    }

    public void removerSolicitacao(Solicitacao solicitacao) {
        this.getSolicitacoes().remove(solicitacao);
    }

    public void adicionarAmigo(Usuario amigo) {
        this.getAmigos().add(amigo);
        amigo.getAmigos().add(this);
    }

    public void removerAmigo(Usuario amigo) {
        this.getAmigos().remove(amigo);
        amigo.getAmigos().remove(this);
    }

    public void removerCurtida(Curtida curtida) {
        this.getCurtidas().remove(curtida);
    }
}
