package br.com.cwi.crescer.tcc.security.controller;

import br.com.cwi.crescer.tcc.controller.response.SolicitacaoResponse;
import br.com.cwi.crescer.tcc.security.controller.request.UsuarioEditadoRequest;
import br.com.cwi.crescer.tcc.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioEditadoResponse;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioListadoResponse;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.tcc.security.service.*;
import br.com.cwi.crescer.tcc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.cwi.crescer.tcc.security.domain.Funcao.Nomes.USUARIO;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService service;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioEditadoService usuarioEditadoService;

    @Autowired
    private EnviarSolicitacaoService enviarSolicitacaoService;

    @Autowired
    private ListarSolicitacaoService listarSolicitacaoService;

    @Autowired
    private AceitarSolicitacaoService aceitarSolicitacaoService;

    @Autowired
    private DeletarAmizadeService deletarAmizadeService;

    @Autowired
    private ListarAmigosService listarAmigosService;

    @Autowired
    private SelecionarUsuarioService selecionarUsuarioService;

    @Autowired
    private UsuariosPorNomeOuEmailService usuariosPorNomeOuEmailService;

    @PostMapping
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return service.incluir(request);
    }

    @Secured(USUARIO)
    @GetMapping("/me")
    public UsuarioDetalhadoResponse detalhar() {
        return usuarioAutenticadoService.getMeResponse();
    }

    @Secured(USUARIO)
    @PutMapping("/me/editar")
    public UsuarioEditadoResponse editar(@Valid @RequestBody UsuarioEditadoRequest request) {
        return usuarioEditadoService.editar(request);
    };

    @Secured(USUARIO)
    @PostMapping("/me/solicitacao/{id}")
    @ResponseStatus(CREATED)
    public void enviarSolicatacao(@PathVariable Long id ) {
        enviarSolicitacaoService.enviar(id);
    }

    @Secured(USUARIO)
    @GetMapping("/me/solicitacoes")
    public Page<SolicitacaoResponse> listarSolicitacao(Pageable pageable) {
        return listarSolicitacaoService.listar(pageable);
    }

    @Secured(USUARIO)
    @PostMapping("/me/solicitacao/{id}/aceitar")
    @ResponseStatus(CREATED)
    public void aceitarSolicatacao(@PathVariable Long id) {
        aceitarSolicitacaoService.aceitar(id);
    }

    @Secured(USUARIO)
    @DeleteMapping("/me/solicitacao/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarAmizade(@PathVariable Long id) {
        deletarAmizadeService.deletar(id);
    }

    @Secured(USUARIO)
    @GetMapping("/me/amigos")
    public Page<UsuarioListadoResponse> listarAmigos(Pageable pageable) {
        return listarAmigosService.listar(pageable);
    }

    @Secured(USUARIO)
    @GetMapping("/me/solicitacoes/{id}")
    public UsuarioDetalhadoResponse selecionarUsuario(@PathVariable Long id) {
        return selecionarUsuarioService.selecionar(id);
    }

    @Secured(USUARIO)
    @GetMapping("/procurar")
    public Page<UsuarioListadoResponse> procurar(@RequestParam String texto, Pageable pageable) {
        return usuariosPorNomeOuEmailService.procurar(texto, pageable);
    }

    @Secured(USUARIO)
    @GetMapping("/amigos/procurar")
    public Page<UsuarioListadoResponse> procurarAmigos(@RequestParam String texto, Pageable pageable) {
        return usuariosPorNomeOuEmailService.procurarAmigos(texto, pageable);
    }
}
