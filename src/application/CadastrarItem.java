package application;

import domain.item.Categoria;
import domain.item.Item;
import domain.user.UserId;

public class CadastrarItem {

    private final infrastructure.ItemRepositorio repositorio;

    public CadastrarItem(infrastructure.ItemRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Item executar(String nome, String descricao,
                         Categoria categoria, UserId donoId, int valorEmCreditos) {
        Item item = new Item(nome, descricao, categoria, donoId, valorEmCreditos);
        repositorio.salvar(item);
        return item;
    }
}