package domain.negotiation;

import domain.user.User;

public class Venda {

    private final User comprador;
    private final User vendedor;
    private final int valor;

    public Venda(User comprador, User vendedor, int valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }

        this.comprador = comprador;
        this.vendedor = vendedor;
        this.valor = valor;
    }

    public void realizarVenda() {

        if (!comprador.temCreditospara(valor)) {
            throw new IllegalStateException("Créditos insuficientes.");
        }

        comprador.gastarCreditos(valor);
        vendedor.ganharCreditos(valor);
    }
}