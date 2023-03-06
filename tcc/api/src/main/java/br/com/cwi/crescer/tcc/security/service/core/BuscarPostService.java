package br.com.cwi.crescer.tcc.security.service.core;

import br.com.cwi.crescer.tcc.domain.Post;
import br.com.cwi.crescer.tcc.security.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarPostService {

    @Autowired
    private PostRepository postRepository;

    public Post porId(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Post não encontrado"));
    }
}
