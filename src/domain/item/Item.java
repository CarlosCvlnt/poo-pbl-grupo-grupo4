package domain.item;

import domain.user.UserId;
import java.util.Objects;

public final class Item {

    private final ItemId id;
    private final String nome;
    private final String descricao;
    private final Categoria categoria;
    private final UserId donoId;
    private final int valorEmCreditos;
    private boolean disponivel;

    public Item(String nome, String descricao, Categoria categoria,
                UserId donoId, int valorEmCreditos) {

        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome do item não pode ser vazio.");
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        if (categoria == null)
            throw new IllegalArgumentException("Categoria é obrigatória.");
        if (donoId == null)
            throw new IllegalArgumentException("Dono é obrigatório.");
        if (valorEmCreditos <= 0)
            throw new IllegalArgumentException("Valor em créditos deve ser positivo.");

        this.id = ItemId.generate();
        this.nome = nome.trim();
        this.descricao = descricao.trim();
        this.categoria = categoria;
        this.donoId = donoId;
        this.valorEmCreditos = valorEmCreditos;
        this.disponivel = true;
    }

    public void desativar() {
        this.disponivel = false;
    }

    public ItemId getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Categoria getCategoria() { return categoria; }
    public UserId getDonoId() { return donoId; }
    public int getValorEmCreditos() { return valorEmCreditos; }
    public boolean isDisponivel() { return disponivel; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        return id.equals(((Item) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Item{nome='%s', categoria=%s, valor=%d, disponivel=%s}",
                nome, categoria, valorEmCreditos, disponivel);
    }
}

