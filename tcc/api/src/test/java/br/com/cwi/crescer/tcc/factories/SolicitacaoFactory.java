package br.com.cwi.crescer.tcc.factories;

import br.com.cwi.crescer.tcc.domain.Estado;
import br.com.cwi.crescer.tcc.domain.Solicitacao;
import br.com.cwi.crescer.tcc.security.domain.Usuario;

public class SolicitacaoFactory {

    public static Solicitacao get(Estado estado) {

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setUsuario(UsuarioFactory.get());
        solicitacao.setAmigoId(SimpleFactory.getRandomLong());
        solicitacao.setEstado(estado);
        return solicitacao;
    }
}
