package domain.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditosTest {

    @Test
    void criarCreditosValidos(){

        int amount = 2;

        Creditos creditos = Creditos.of(amount);

        assertEquals(2, creditos.quantidadeCredito());

    }

    @Test
    void criarCreditosInvalidos(){

        int amount = -1;

        assertThrows(IllegalArgumentException.class, () -> Creditos.of(amount));

    }
    @Test
    void criarCreditosZero(){

        int amount = 0;

        Creditos creditos = Creditos.of(amount);

        assertEquals(0, creditos.quantidadeCredito());

    }
    @Test
    void addCreditosValidos() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = 1;

        Creditos creditosInseridos = creditosIniciais.add(value);

        assertEquals(11, creditosInseridos.quantidadeCredito());

    }
    @Test
    void addCreditosInvalidos() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = -1;

        assertThrows(IllegalArgumentException.class, () -> creditosIniciais.add(value));

    }
    @Test
    void addCreditosZero() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = 0;

        assertThrows(IllegalArgumentException.class, () -> creditosIniciais.add(value));
    }
    @Test
    void subCreditosValidos() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = 1;

        Creditos creditosSubtraidos = creditosIniciais.subtract(value);
        assertEquals(9, creditosSubtraidos.quantidadeCredito());
    }
    @Test
    void subCreditosInvalidos() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = -1;

        assertThrows(IllegalArgumentException.class, () -> creditosIniciais.subtract(value));
    }
    @Test
    void subCreditosZero() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = 0;

        assertThrows(IllegalArgumentException.class, () -> creditosIniciais.subtract(value));
    }
    @Test
    void subCreditosInsuficientes() {

        Creditos creditosIniciais = Creditos.of(10);
        int value = 11;

        assertThrows(IllegalStateException.class, () -> creditosIniciais.subtract(value));
    }
    @Test
    void creditosSuficientes() {

        Creditos creditos = Creditos.of(10);
        assertTrue(creditos.SuficientePara(5));

    }
    @Test
    void creditosInsuficientes() {

        Creditos creditos = Creditos.of(10);
        assertFalse(creditos.SuficientePara(15));

    }
}
