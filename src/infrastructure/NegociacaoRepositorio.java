package infrastructure;

import domain.negotiation.PropostaTroca;
import java.util.ArrayList;
import java.util.List;

public class NegociacaoRepositorio {

    private final List<PropostaTroca> propostas = new ArrayList<>();

    public void salvar(PropostaTroca proposta) {
        propostas.add(proposta);
    }

    public List<PropostaTroca> listarTodas() {
        return new ArrayList<>(propostas);
    }
}