package domain.user;

import java.util.regex.Pattern;

// Value object que valida e armazena um endereço de e-mail
public final class Email {

    private static final Pattern PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private final String value;

    private Email(String value) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("E-mail não pode ser vazio.");
        if (!PATTERN.matcher(value).matches())
            throw new IllegalArgumentException("E-mail inválido: " + value);
        this.value = value.toLowerCase();
    }

    public static Email of(String value) { return new Email(value); }
    public String getValue()             { return value; }

    @Override
    public String toString() { return value; }
}
