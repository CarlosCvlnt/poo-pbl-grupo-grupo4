package domain.system;

public class Categoria {

    private String tipo;
    private int valorCredito;

    public Categoria(String tipo) {
        this.tipo = tipo;
        this.valorCredito = calcularValor(tipo);
    }

    private int calcularValor(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "livro"      -> 250;
            case "brinquedo"  -> 150;
            case "eletronico" -> 500;
            default           -> 0;
        };
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.valorCredito = calcularValor(tipo);
    }

    public int getValorCredito() {
        return valorCredito;
    }
}
