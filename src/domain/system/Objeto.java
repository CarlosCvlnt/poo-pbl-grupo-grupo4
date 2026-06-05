package domain.system;

import java.util.ArrayList;
import java.util.List;

//valor do objeto é decidido dependendo do tipo
public class Objeto {

    Integer valor;
    String nome;
    String tipo;

    Objeto(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;

        this.valor = decidirValor(tipo);
    }

    private int decidirValor(String tipo){
        if (tipo.equalsIgnoreCase("livro")){
            return 250;
        }
        if (tipo.equalsIgnoreCase("brinquedo")){
            return 150;
        }
        if (tipo.equalsIgnoreCase("movel")){
            return 700;
        }
        if (tipo.equalsIgnoreCase("eletronico")){
            return 500;
        }
        else {
            return 0;
        }
    }

public class registrados{

    List<Objeto> objetos = new ArrayList<>();

    public void addobjetos(String tipo, String nome){
        Objeto objetoadd = new Objeto(nome, tipo);
        objetos.add(objetoadd);
    }
    }
}
