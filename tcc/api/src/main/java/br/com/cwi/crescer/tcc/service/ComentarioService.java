package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.controller.request.ComentarioRequest;
import br.com.cwi.crescer.tcc.controller.response.ComentarioResponse;
import br.com.cwi.crescer.tcc.domain.Comentario;
import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.mapper.ComentarioMapper;
import br.com.cwi.crescer.tcc.repository.ComentarioRepository;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.tcc.security.service.core.BuscarPostService;
import br.com.cwi.crescer.tcc.security.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioService {

    @Autowired
    private NowService nowService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private BuscarPostService buscarPostService;

    @Transactional
    public ComentarioResponse comentar(Long id, ComentarioRequest request) {

        Comentario comentario = ComentarioMapper.toEntity(request);
        Usuario usuario = usuarioAutenticadoService.get();
        Post post = buscarPostService.porId(id);

        comentario.setDataComentario(nowService.getDate());
        comentario.setUsuario(usuario);
        comentario.setPost(post);

        usuario.getComentarios().add(comentario);
        post.getComentarios().add(comentario);

        comentarioRepository.save(comentario);

        return ComentarioMapper.toResponse(comentario);
    }
}
