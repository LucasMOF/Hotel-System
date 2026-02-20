package repository;

import exception.QuartoNaoEncontradoException;
import model.Quarto;
import model.enums.StatusQuarto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuartoRepository {
    private List<Quarto> quartos;

    public QuartoRepository() {
        this.quartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public Quarto buscarPorNumero(int numero) {
        return quartos.stream()
                .filter(q -> q.getNumero() == numero)
                .findFirst()
                .orElseThrow(() -> new QuartoNaoEncontradoException("Quarto " + numero + " não existe!"));
    }

    public List<Quarto> listarQuartosDisponiveis() {
        return quartos.stream()
                .filter(disponivel -> disponivel.getStatus() == StatusQuarto.DISPONIVEL)
                .toList();
    }
}
