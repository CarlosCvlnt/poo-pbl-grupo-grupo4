package domain.user;

import java.util.Objects;
import java.util.UUID;

public final class UserId {

    private final String value;

    private UserId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserId não pode ser vazio.");
        }
        this.value = value;
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID().toString());
    }

    public static UserId of(String value) {
        return new UserId(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId)) return false;
        return value.equals(((UserId) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}