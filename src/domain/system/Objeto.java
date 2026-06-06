package domain.system;
import java.util.ArrayList;
import java.util.List;
import domain.user.*;

public class Objeto {


    private String nome;
    private ItemId itemid;
    private Categoria tipo;

    public Objeto(String tipo, User dono, String nome) {
        this.itemid = ItemId.generate();
        this.tipo = new Categoria(tipo);
        this.nome = nome;
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
        return String.format("Categoria: %s | Nome: %s", tipo.getTipo(), getNome());
    }
}
