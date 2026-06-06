package domain.system;

import javax.smartcardio.Card;

public class Categoria {

    private String tipo;
    private final Integer valorcredito;

    public Categoria(String tipo){
        this.tipo = tipo;

        this.valorcredito = decidirValor(tipo);
    }

    private int decidirValor(String tipo) {
        if (tipo.equalsIgnoreCase("livro")) {
            return 250;
        }
        if (tipo.equalsIgnoreCase("brinquedo")) {
            return 150;
        }
        if (tipo.equalsIgnoreCase("eletronico")) {
            return 500;
        }
        else {
            return 0;
        }
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Integer getValorcredito(){
        return valorcredito;
    }

}
