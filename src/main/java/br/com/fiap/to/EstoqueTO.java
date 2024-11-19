package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class EstoqueTO {
    private Long idEstoque;
    private Long idGerador;
    @NotNull @PositiveOrZero private int quantidadeDisponivel;
    @NotNull @PositiveOrZero private int quantidadeReservada;

    public EstoqueTO() {
    }

    public EstoqueTO(Long idEstoque, Long idGerador, int quantidadeDisponivel, int quantidadeReservada) {
        this.idEstoque = idEstoque;
        this.idGerador = idGerador;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeReservada = quantidadeReservada;
    }

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Long getIdGerador() {
        return idGerador;
    }

    public void setIdGerador(Long idGerador) {
        this.idGerador = idGerador;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getQuantidadeReservada() {
        return quantidadeReservada;
    }

    public void setQuantidadeReservada(int quantidadeReservada) {
        this.quantidadeReservada = quantidadeReservada;
    }
}
