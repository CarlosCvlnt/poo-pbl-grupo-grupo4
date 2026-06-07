package domain.negotiation;

import domain.user.Email;
import domain.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}