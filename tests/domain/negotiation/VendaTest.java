package domain.negotiation;

import domain.user.Email;
import domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {

    @Test
    void deveRealizarVenda() {

        User comprador =
                new User("Pedro", Email.of("pedro@email.com"));

        User vendedor =
                new User("Maria", Email.of("maria@email.com"));

        comprador.ganharCreditos(100);

        Venda venda =
                new Venda(comprador, vendedor, 50);

        venda.realizarVenda();

        assertEquals(
                50,
                comprador.getCredits().quantidadeCredito()
        );

        assertEquals(
                50,
                vendedor.getCredits().quantidadeCredito()
        );
    }

    @Test
    void deveRejeitarValorZero() {

        User comprador =
                new User("Pedro", Email.of("pedro@email.com"));

        User vendedor =
                new User("Maria", Email.of("maria@email.com"));

        assertThrows(IllegalArgumentException.class, () ->
                new Venda(comprador, vendedor, 0));
    }

    @Test
    void deveRejeitarValorNegativo() {

        User comprador =
                new User("Pedro", Email.of("pedro@email.com"));

        User vendedor =
                new User("Maria", Email.of("maria@email.com"));

        assertThrows(IllegalArgumentException.class, () ->
                new Venda(comprador, vendedor, -1));
    }

    @Test
    void deveRejeitarVendaComSaldoInsuficiente() {

        User comprador =
                new User("Pedro", Email.of("pedro@email.com"));

        User vendedor =
                new User("Maria", Email.of("maria@email.com"));

        comprador.ganharCreditos(100);

        Venda venda =
                new Venda(comprador, vendedor, 250);

        assertThrows(IllegalStateException.class, () ->
                venda.realizarVenda());
    }
}