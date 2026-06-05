package domain.system;
import java.util.ArrayList;
import java.util.List;

public class Objeto {

    String tipo;
    String dono;
    String nome;
    int valor;

    public Objeto(String tipo, String dono, String nome) {
        this.tipo = tipo;
        this.dono = dono;
        this.nome = nome;

        this.valor = decidirValor(tipo);
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

    public static class registrarobj {

        List<Objeto> objetos = new ArrayList<>();

        public void adicionarObjeto(String tipo, String dono, String nome) {
            Objeto obj = new Objeto(tipo, dono, nome);
            objetos.add(obj);
        }
    }
}
