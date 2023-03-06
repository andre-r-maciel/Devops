package br.com.cwi.crescer.tcc.controller;

import br.com.cwi.crescer.tcc.controller.request.ComentarioRequest;
import br.com.cwi.crescer.tcc.controller.request.PostRequest;
import br.com.cwi.crescer.tcc.controller.response.ComentarioResponse;
import br.com.cwi.crescer.tcc.controller.response.CurtidaResponse;
import br.com.cwi.crescer.tcc.controller.response.PostResponse;
import br.com.cwi.crescer.tcc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.cwi.crescer.tcc.security.domain.Funcao.Nomes.USUARIO;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/usuarios")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ListarFeedService listarFeedService;

    @Autowired
    private ListarPostsUsuarioService listarPostsUsuarioService;

    @Autowired
    private ListarPostsPublicosService listarPostsPublicosService;

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private ComentarioListadoService comentarioListadoService;

    @Autowired
    private CurtirService curtirService;

    @Autowired
    private DescurtirService descurtirService;

    @Autowired
    private ContarCurtidaService contarCurtidaService;

    @Secured(USUARIO)
    @PostMapping("/me/post")
    public PostResponse postar(@Valid @RequestBody PostRequest request) {
        return postService.postar(request);
    }

    @Secured(USUARIO)
    @GetMapping("/me/posts")
    public Page<PostResponse> listarFeed(Pageable pageable) {
        return listarFeedService.listar(pageable);
    }

    @Secured(USUARIO)
    @GetMapping("/me/posts/{id}")
    public Page<PostResponse> listarPostsUsuario(@PathVariable Long id, Pageable pageable) {
        return listarPostsUsuarioService.listar(id, pageable);
    }

    @Secured(USUARIO)
    @GetMapping("/me/posts/{id}/publicos")
    public Page<PostResponse> listarPostsPublicos(@PathVariable Long id, Pageable pageable) {
        return listarPostsPublicosService.listar(id, pageable);
    }

    @Secured(USUARIO)
    @PostMapping("/me/posts/{id}/comentarios")
    public ComentarioResponse comentar(@PathVariable Long id, @Valid @RequestBody ComentarioRequest request) {
        return comentarioService.comentar(id, request);
    }

    @Secured(USUARIO)
    @GetMapping("/posts/{id}/comentarios")
    public Page<ComentarioResponse> listar(@PathVariable Long id, Pageable pageable) {
        return comentarioListadoService.listar(id, pageable);
    }

    @Secured(USUARIO)
    @PostMapping("/me/posts/{id}/curtidas")
    @ResponseStatus(CREATED)
    public void curtir(@PathVariable Long id) {
        curtirService.curtir(id);
    }

    @Secured(USUARIO)
    @DeleteMapping("/me/posts/{id}/curtidas")
    @ResponseStatus(CREATED)
    public void descurtir(@PathVariable Long id) {
        descurtirService.descurtir(id);
    }

    @Secured(USUARIO)
    @GetMapping("/me/posts/{id}/curtidas")
    public CurtidaResponse contar(@PathVariable Long id) {
        return contarCurtidaService.contar(id);
    }
}
