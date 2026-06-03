package domain.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void CriarUsuarioValido() {
        Email email = Email.of("usuario@email.com");

        User user = new User("João", email);

        assertEquals("João", user.getName());
        assertEquals(email, user.getEmail());
        assertTrue(user.isActive());
    }

    @Test
    void RejeitarNomeVazio() {
        Email email = Email.of("usuario@email.com");

        assertThrows(IllegalArgumentException.class, () -> new User("", email));
    }

    @Test
    void RejeitarNomeNulo() {
        Email email = Email.of("usuario@email.com");

        assertThrows(IllegalArgumentException.class, () -> new User(null, email));
    }

    @Test
    void RejeitarEmailNulo() {
        assertThrows(NullPointerException.class, () -> new User("João", null));
    }

    @Test
    void GanharCreditos() {
        User user = new User("João", Email.of("usuario@email.com"));

        user.ganharCreditos(10);

        assertEquals(10, user.getCredits().quantidadeCredito());
    }

    @Test
    void GastarCreditos() {
        User user = new User("João", Email.of("usuario@email.com"));
        user.ganharCreditos(10);

        user.gastarCreditos(5);

        assertEquals(5, user.getCredits().quantidadeCredito());
    }

    @Test
    void DesativarUsuario() {
        User user = new User("João", Email.of("usuario@email.com"));

        user.desativar();

        assertFalse(user.isActive());
    }
}