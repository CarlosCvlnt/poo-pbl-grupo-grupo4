package domain.user;

public final class Creditos {

    private final int amount;

    private Creditos(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Créditos não podem ser negativos.");
        }
        this.amount = amount;
    }

    public static Creditos of(int amount) {
        return new Creditos(amount);
    }

    public static Creditos zero() {
        return new Creditos(0);
    }

    public Creditos add(int value) {
        if (value <= 0) throw new IllegalArgumentException("Valor a adicionar deve ser positivo.");
        return new Creditos(this.amount + value);
    }

    public Creditos subtract(int value) {
        if (value <= 0) throw new IllegalArgumentException("Valor a subtrair deve ser positivo.");
        if (this.amount < value) throw new IllegalStateException("Créditos insuficientes.");
        return new Creditos(this.amount - value);
    }

    public boolean SuficientePara(int cost) {
        return this.amount >= cost;
    }

    public int quantidadeCredito() {
        return amount;
    }

    @Override
    public String toString() {
        return amount + " créditos";
    }
}