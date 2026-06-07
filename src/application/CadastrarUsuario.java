package application;

import domain.user.Email;
import domain.user.User;

public class CadastrarUsuario {

    private final infrastructure.UsuarioRepositorio repositorio;

    public CadastrarUsuario(infrastructure.UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public User executar(String nome, String email) {
        User user = new User(nome, Email.of(email));
        repositorio.salvar(user);
        return user;
    }
}