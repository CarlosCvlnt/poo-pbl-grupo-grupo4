package domain.negotiation;

import domain.user.Email;
import domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropostaTrocaTest {

    @Test
    void deveCriarPropostaPendente() {

        User proponente =
                new User("Pedro", Email.of("pedro@email.com"));

        User destinatario =
                new User("Maria", Email.of("maria@email.com"));

        PropostaTroca proposta =
                new PropostaTroca(proponente, destinatario);

        assertEquals(
                StatusProposta.PENDENTE,
                proposta.getStatus()
        );
    }

    @Test
    void deveAceitarProposta() {

        User proponente =
                new User("Pedro", Email.of("pedro@email.com"));

        User destinatario =
                new User("Maria", Email.of("maria@email.com"));

        PropostaTroca proposta =
                new PropostaTroca(proponente, destinatario);

        proposta.aceitar();

        assertEquals(
                StatusProposta.ACEITA,
                proposta.getStatus()
        );
    }

    @Test
    void deveRecusarProposta() {

        User proponente =
                new User("Pedro", Email.of("pedro@email.com"));

        User destinatario =
                new User("Maria", Email.of("maria@email.com"));

        PropostaTroca proposta =
                new PropostaTroca(proponente, destinatario);

        proposta.recusar();

        assertEquals(
                StatusProposta.RECUSADA,
                proposta.getStatus()
        );
    }

    @Test
    void deveRejeitarProponenteNulo() {

        User destinatario =
                new User("Maria", Email.of("maria@email.com"));

        assertThrows(IllegalArgumentException.class, () ->
                new PropostaTroca(null, destinatario));
    }

    @Test
    void deveRejeitarDestinatarioNulo() {

        User proponente =
                new User("Pedro", Email.of("pedro@email.com"));

        assertThrows(IllegalArgumentException.class, () ->
                new PropostaTroca(proponente, null));
    }

    @Test
    void deveRejeitarAceitarPropostaJaFinalizada() {

        User proponente =
                new User("Pedro", Email.of("pedro@email.com"));

        User destinatario =
                new User("Maria", Email.of("maria@email.com"));

        PropostaTroca proposta =
                new PropostaTroca(proponente, destinatario);

        proposta.recusar();

        assertThrows(IllegalStateException.class, () ->
                proposta.aceitar());
    }

    @Test
    void deveRejeitarRecusarPropostaJaFinalizada() {

        User proponente =
                new User("Pedro", Email.of("pedro@email.com"));

        User destinatario =
                new User("Maria", Email.of("maria@email.com"));

        PropostaTroca proposta =
                new PropostaTroca(proponente, destinatario);

        proposta.aceitar();

        assertThrows(IllegalStateException.class, () ->
                proposta.recusar());
    }
}