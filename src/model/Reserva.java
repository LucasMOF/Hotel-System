package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva(LocalDate checkIn, LocalDate checkOut,Hospede hospede, Quarto quarto) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.hospede = hospede;
        this.quarto = quarto;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public double calcularEstadia() {
        double dias = ChronoUnit.DAYS.between(checkIn, checkOut);
        return dias * quarto.getValorDiaria();
    }
}
