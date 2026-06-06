package domain.system;

import java.util.UUID;

public final class ItemId {

    private final String valor;

    private ItemId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserId não pode ser vazio.");
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

}