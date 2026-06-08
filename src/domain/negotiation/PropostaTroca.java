package domain.negotiation;

import domain.user.User;

// Representa uma proposta de troca entre dois usuários
public class PropostaTroca {

    private final User proponente;
    private final User destinatario;
    private StatusProposta status;

    public PropostaTroca(User proponente, User destinatario) {
        if (proponente == null || destinatario == null)
            throw new IllegalArgumentException("Usuários são obrigatórios.");
        this.proponente   = proponente;
        this.destinatario = destinatario;
        this.status       = StatusProposta.PENDENTE;
    }

    public void aceitar() {
        validarPendente();
        status = StatusProposta.ACEITA;
    }

    public void recusar() {
        validarPendente();
        status = StatusProposta.RECUSADA;
    }

    private void validarPendente() {
        if (status != StatusProposta.PENDENTE)
            throw new IllegalStateException("Proposta já finalizada.");
    }

    public StatusProposta getStatus()  { return status; }
    public User getProponente()        { return proponente; }
    public User getDestinatario()      { return destinatario; }
}
