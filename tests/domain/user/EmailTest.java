package domain.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void aceitaEmailValido() {

        String emailValido = "teste@email.com";

        Email email = Email.of(emailValido);

        assertEquals("teste@email.com", email.getValue());
    }
    @Test
    void rejeitaEmailInvalido() {

        String emailInvalido = "emailsemarroba";

        assertThrows(IllegalArgumentException.class, () -> Email.of(emailInvalido));

    }
    @Test
    void rejeitaEmailVazio() {

        String emailVazio = "";

        assertThrows(IllegalArgumentException.class, () -> Email.of(emailVazio));

    }
    @Test
    void rejeitaEmailNull() {

        String emailNull = null;

        assertThrows(IllegalArgumentException.class, () -> Email.of(emailNull));

    }
}
