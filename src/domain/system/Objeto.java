package domain.system;
import java.util.ArrayList;
import java.util.List;
import domain.user.*;

public class Objeto {

    String tipo;
    User dono;
    String nome;
    int valor;

    public Objeto(String tipo, User dono, String nome) {
        this.tipo = tipo;
        this.nome = nome;
        this.dono = dono;

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

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public static class registrarobj {

        List<Objeto> objetos = new ArrayList<>();

        public void adicionarObjeto(String tipo, User dono, String nome) {
            Objeto obj = new Objeto(tipo, dono, nome);
            objetos.add(obj);
        }
    }

    public String MostrarDetalhes(){
        return String.format("Categoria: %s | Nome: %s", getTipo(), getNome());
    }
}
