package domain.item;

import domain.user.UserId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void deveCriarItemValido() {
        UserId donoId = UserId.generate();

        Item item = new Item("Harry Potter", "Livro em ótimo estado",
                Categoria.LIVRO, donoId, 250);

        assertEquals("Harry Potter", item.getNome());
        assertEquals("Livro em ótimo estado", item.getDescricao());
        assertEquals(Categoria.LIVRO, item.getCategoria());
        assertEquals(250, item.getValorEmCreditos());
        assertTrue(item.isDisponivel());
    }

    @Test
    void deveRejeitarNomeVazio() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item("", "Descrição", Categoria.LIVRO, donoId, 250));
    }

    @Test
    void deveRejeitarNomeNulo() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item(null, "Descrição", Categoria.LIVRO, donoId, 250));
    }

    @Test
    void deveRejeitarDescricaoVazia() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item("Harry Potter", "", Categoria.LIVRO, donoId, 250));
    }

    @Test
    void deveRejeitarDescricaoNula() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item("Harry Potter", null, Categoria.LIVRO, donoId, 250));
    }

    @Test
    void deveRejeitarCategoriaNula() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item("Harry Potter", "Descrição", null, donoId, 250));
    }

    @Test
    void deveRejeitarDonoNulo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Item("Harry Potter", "Descrição", Categoria.LIVRO, null, 250));
    }

    @Test
    void deveRejeitarValorZero() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item("Harry Potter", "Descrição", Categoria.LIVRO, donoId, 0));
    }

    @Test
    void deveRejeitarValorNegativo() {
        UserId donoId = UserId.generate();

        assertThrows(IllegalArgumentException.class, () ->
                new Item("Harry Potter", "Descrição", Categoria.LIVRO, donoId, -1));
    }

    @Test
    void deveDesativarItem() {
        UserId donoId = UserId.generate();
        Item item = new Item("Harry Potter", "Descrição", Categoria.LIVRO, donoId, 250);

        item.desativar();

        assertFalse(item.isDisponivel());
    }
}