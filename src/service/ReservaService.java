package service;

import exception.DataInvalidaException;
import exception.QuartoIndisponivelException;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.enums.StatusQuarto;
import repository.QuartoRepository;
import repository.ReservaRepository;

import java.time.LocalDate;

public class ReservaService {
    private QuartoRepository quartoRepository;
    private ReservaRepository reservaRepository;

    public ReservaService(QuartoRepository quartoRepository, ReservaRepository reservaRepository) {
        this.quartoRepository = quartoRepository;
        this.reservaRepository = reservaRepository;
    }

    public Reserva realizarReserva(String nomeHospede, String cpfHospede, int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        if (dataEntrada.isAfter(dataSaida)) throw new DataInvalidaException("Data inválida!");

        Quarto quartoEncontrado = quartoRepository.buscarPorNumero(numeroQuarto);

        if (quartoEncontrado.getStatus() != StatusQuarto.DISPONIVEL) {
            throw new QuartoIndisponivelException("O quarto " + numeroQuarto + " não está disponível para reserva.");
        }
        Hospede hospede = new Hospede(nomeHospede, cpfHospede);
        Reserva reserva = new Reserva(dataEntrada, dataSaida, hospede, quartoEncontrado);

        quartoEncontrado.setStatus(StatusQuarto.OCUPADO);

        reservaRepository.adicionarReserva(reserva);

        return reserva;
    }
}
