package model;

import model.enums.StatusQuarto;
import model.enums.TipoQuarto;

public class Quarto {
    private int numero;
    private TipoQuarto tipo;
    private StatusQuarto status;
    private double valorDiaria;

    public Quarto(int numero, TipoQuarto tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.status = StatusQuarto.DISPONIVEL;
    }

    public int getNumero() {
        return numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public StatusQuarto getStatus() {
        return status;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }



}
