package domain.user;

import java.util.Objects;

public class User {

    private final UserId id;
    private String name;
    private final Email email;
    private Creditos creditos;
    private boolean active;

    public User(String name, Email email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio.");
        }
        this.id      = UserId.generate();
        this.name    = name.trim();
        this.email   = Objects.requireNonNull(email, "E-mail é obrigatório.");
        this.creditos = Creditos.zero();
        this.active  = true;
    }

    public void ganharCreditos(int amount) {
        this.creditos = this.creditos.add(amount);
    }

    public void gastarCredits(int amount) {
        this.creditos = this.creditos.subtract(amount);
    }

    public boolean temCreditospara(int cost) {
        return creditos.Suficientepara(cost);
    }

    public void desativar() {
        this.active = false;
    }

    public UserId getId()       { return id; }
    public String getName()     { return name; }
    public Email getEmail()     { return email; }
    public Creditos getCredits() { return creditos; }
    public boolean isActive()   { return active; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', email=%s, credits=%s, active=%s}",
                name, email, creditos, active);
    }
}