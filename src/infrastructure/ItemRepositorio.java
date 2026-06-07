package infrastructure;

import domain.item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepositorio {

    private final List<Item> itens = new ArrayList<>();

    public void salvar(Item item) {
        itens.add(item);
    }

    public Optional<Item> buscarPorId(String id) {
        return itens.stream()
                .filter(i -> i.getId().getValor().equals(id))
                .findFirst();
    }

    public List<Item> listarTodos() {
        return new ArrayList<>(itens);
    }

    public List<Item> listarDisponiveis() {
        return itens.stream()
                .filter(Item::isDisponivel)
                .toList();
    }
}