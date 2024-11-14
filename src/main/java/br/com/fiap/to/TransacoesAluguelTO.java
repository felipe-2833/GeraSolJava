package br.com.fiap.to;

import java.time.LocalDate;

public class TransacoesAluguelTO {
    private Long idAluguel;
    private Long idPedido;
    private Long idUsuario;
    private Long idGerador;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int diasAluguel;
    private Double valorDiario;
    private Double totalAluguel;
    private String statusAluguel;

    public TransacoesAluguelTO() {
    }

    public TransacoesAluguelTO(Long idAluguel, Long idPedido, Long idUsuario, Long idGerador, LocalDate dataInicio, LocalDate dataFim, int diasAluguel, Double valorDiario, Double totalAluguel, String statusAluguel) {
        this.idAluguel = idAluguel;
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idGerador = idGerador;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diasAluguel = diasAluguel;
        this.valorDiario = valorDiario;
        this.totalAluguel = totalAluguel;
        this.statusAluguel = statusAluguel;
    }

    public Long getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Long idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdGerador() {
        return idGerador;
    }

    public void setIdGerador(Long idGerador) {
        this.idGerador = idGerador;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getDiasAluguel() {
        return diasAluguel;
    }

    public void setDiasAluguel(int diasAluguel) {
        this.diasAluguel = diasAluguel;
    }

    public Double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(Double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public Double getTotalAluguel() {
        return totalAluguel;
    }

    public void setTotalAluguel(Double totalAluguel) {
        this.totalAluguel = totalAluguel;
    }

    public String getStatusAluguel() {
        return statusAluguel;
    }

    public void setStatusAluguel(String statusAluguel) {
        this.statusAluguel = statusAluguel;
    }
}
