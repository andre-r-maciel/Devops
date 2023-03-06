package br.com.cwi.crescer.tcc.service;

import br.com.cwi.crescer.tcc.factories.UsuarioFactory;
import br.com.cwi.crescer.tcc.security.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.crescer.tcc.security.domain.Usuario;
import br.com.cwi.crescer.tcc.security.service.core.BuscarUsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SelecionarUsuarioServiceTest {

    @InjectMocks
    private SelecionarUsuarioService tested;

    @Mock
    private BuscarUsuarioService buscarUsuarioService;

    @Test
    @DisplayName("Deve mostrar nome, email, apelido, data de nascimento, foto e assombrado do usuario selecionado")
    void deveSelecionarUsuario() {

        Usuario usuario = UsuarioFactory.get();

        Long usuarioId = usuario.getId();
        String usuarioNome = usuario.getNome();
        String usuarioEmail = usuario.getEmail();
        String usuarioApelido = usuario.getApelido();
        String usuarioFotoPerfil = usuario.getFotoPerfil();
        LocalDate usuarioDataNascimento = usuario.getDataNascimento();
        Boolean usuarioAssombracao = usuario.isAssombracao();

        when(buscarUsuarioService.porId(usuarioId)).thenReturn(usuario);

        UsuarioDetalhadoResponse response = tested.selecionar(usuarioId);

        verify(buscarUsuarioService).porId(usuarioId);

        assertEquals(usuarioNome, response.getNome());
        assertEquals(usuarioEmail, response.getEmail());
        assertEquals(usuarioApelido, response.getApelido());
        assertEquals(usuarioFotoPerfil, response.getFotoPerfil());
        assertEquals(usuarioDataNascimento, response.getDataNascimento());
        assertEquals(usuarioAssombracao, response.isAssombracao());
    }

}
