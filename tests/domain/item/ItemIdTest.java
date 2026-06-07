package domain.item;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class ItemIdTest {

        @Test
        void deveCriarItemIdValido() {
            ItemId itemId = ItemId.of("123");

            assertEquals("123", itemId.getValor());
        }

        @Test
        void deveRejeitarItemIdVazio() {
            assertThrows(IllegalArgumentException.class, () -> ItemId.of(""));
        }

        @Test
        void deveRejeitarItemIdNulo() {
            assertThrows(IllegalArgumentException.class, () -> ItemId.of(null));
        }

        @Test
        void deveGerarItemIdUnico() {
            ItemId id1 = ItemId.generate();
            ItemId id2 = ItemId.generate();

            assertNotEquals(id1, id2);
        }

        @Test
        void deveTerIgualdadeEntreIdsIguais() {
            ItemId id1 = ItemId.of("abc-123");
            ItemId id2 = ItemId.of("abc-123");

            assertEquals(id1, id2);
        }
    }

