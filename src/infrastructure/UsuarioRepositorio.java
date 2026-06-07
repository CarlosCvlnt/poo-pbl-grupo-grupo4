package infrastructure;

import domain.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositorio {

    private final List<User> usuarios = new ArrayList<>();

    public void salvar(User user) {
        usuarios.add(user);
    }

    public Optional<User> buscarPorId(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().getValue().equals(id))
                .findFirst();
    }

    public List<User> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}