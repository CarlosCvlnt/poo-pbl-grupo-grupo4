package domain.negotiation;

import domain.user.User;

public class PropostaTroca {

    private final User proponente;
    private final User destinatario;
    private StatusProposta status;

    public PropostaTroca(User proponente, User destinatario) {

        if (proponente == null || destinatario == null) {
            throw new IllegalArgumentException("Usuários são obrigatórios.");
        }

        this.proponente = proponente;
        this.destinatario = destinatario;
        this.status = StatusProposta.PENDENTE;
    }

    public void aceitar() {

        if (status != StatusProposta.PENDENTE) {
            throw new IllegalStateException("Proposta já finalizada.");
        }

        status = StatusProposta.ACEITA;
    }

    public void recusar() {

        if (status != StatusProposta.PENDENTE) {
            throw new IllegalStateException("Proposta já finalizada.");
        }

        status = StatusProposta.RECUSADA;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public User getProponente() {
        return proponente;
    }

    public User getDestinatario() {
        return destinatario;
    }
}