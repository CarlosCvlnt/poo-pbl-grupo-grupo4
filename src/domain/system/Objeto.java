package domain.system;

import domain.user.User;
import java.util.ArrayList;
import java.util.List;

public class Objeto {

    private String nome;
    private final ItemId itemId;
    private Categoria categoria;
    private final User dono;

    public Objeto(String tipo, User dono, String nome) {
        this.itemId    = ItemId.generate();
        this.categoria = new Categoria(tipo);
        this.nome      = nome;
        this.dono      = dono;
    }

    public String getNome()       { return nome; }
    public void setNome(String n) { this.nome = n; }
    public User getDono()         { return dono; }

    public String mostrarDetalhes() {
        return String.format("Categoria: %s | Nome: %s | Dono: %s",
                categoria.getTipo(), nome, dono.getName());
    }

    // Registro de objetos do sistema
    public static class RegistroObjetos {

        private final List<Objeto> objetos = new ArrayList<>();

        public void adicionarObjeto(String tipo, User dono, String nome) {
            objetos.add(new Objeto(tipo, dono, nome));
        }

        public List<Objeto> getObjetos() {
            return objetos;
        }
    }
}
