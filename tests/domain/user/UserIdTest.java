package domain.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserIdTest {

    @Test
    void CriarUserIdValido() {
        UserId userId = UserId.of("123");

        assertEquals("123", userId.getValue());
    }

    @Test
    void RejeitarUserIdVazio() {
        assertThrows(IllegalArgumentException.class, () -> UserId.of(""));
    }

    @Test
    void RejeitarUserIdNulo() {
        assertThrows(IllegalArgumentException.class, () -> UserId.of(null));
    }

    @Test
    void GerarUserIdUnico() {
        UserId id1 = UserId.generate();
        UserId id2 = UserId.generate();

        assertNotEquals(id1, id2);
    }

    @Test
    void TerIgualdadeEntreIdsIguais() {
        UserId id1 = UserId.of("abc-123");
        UserId id2 = UserId.of("abc-123");

        assertEquals(id1, id2);
    }
}