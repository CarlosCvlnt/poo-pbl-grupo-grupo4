package application;

import domain.negotiation.PropostaTroca;
import domain.user.User;

public class ProporTroca {

    private final infrastructure.NegociacaoRepositorio repositorio;

    public ProporTroca(infrastructure.NegociacaoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public PropostaTroca executar(User proponente, User destinatario) {
        PropostaTroca proposta = new PropostaTroca(proponente, destinatario);
        repositorio.salvar(proposta);
        return proposta;
    }
}