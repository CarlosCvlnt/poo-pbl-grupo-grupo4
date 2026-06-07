package application;

import domain.negotiation.Venda;
import domain.user.User;

public class RealizarVenda {

    public void executar(User comprador, User vendedor, int valor) {
        Venda venda = new Venda(comprador, vendedor, valor);
        venda.realizarVenda();
    }
}