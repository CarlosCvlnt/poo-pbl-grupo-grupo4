package domain.item;

import java.util.Objects;
import java.util.UUID;

public final class ItemId {

    private final String valor;

    private ItemId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ItemId não pode ser vazio.");
        }
        this.valor = value;
    }

    public static ItemId generate() {
        return new ItemId(UUID.randomUUID().toString());
    }

    public static ItemId of(String value) {
        return new ItemId(value);
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemId)) return false;
        return valor.equals(((ItemId) o).valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

}