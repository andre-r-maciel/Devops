package br.com.cwi.crescer.tcc.factories;

import br.com.cwi.crescer.tcc.security.domain.Usuario;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get() {

        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNome("Nome Teste");
        usuario.setEmail("email@teste.com");
        usuario.setApelido("Apelido teste");
        usuario.setFotoPerfil("Foto teste");
        usuario.setDataNascimento(LocalDate.of(1985, 12, 13));
        usuario.setAssombracao(false);
        return usuario;
    }
}
