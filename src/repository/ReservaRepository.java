package repository;

import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private List<Reserva> reservas;

    public ReservaRepository() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> buscarPorCpf(String cpf) {
        return reservas.stream()
                .filter(r -> r.getHospede().getCpf().equals(cpf))
                .toList();
    }

    public List<Reserva> buscarPorQuarto(int numeroQuarto) {
        return reservas.stream()
                .filter(r -> r.getQuarto().getNumero() == numeroQuarto)
                .toList();
    }
}
