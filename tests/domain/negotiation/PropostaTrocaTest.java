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
}