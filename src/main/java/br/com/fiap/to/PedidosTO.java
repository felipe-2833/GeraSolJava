package br.com.fiap.to;

import java.time.LocalDate;

public class PedidosTO {
    private Long idPedido;
    private Long idUsuario;
    private LocalDate dataPedido;
    private String status;
    private Double totalPedido;
    private String tipoTransacao;
    private LocalDate dataEntrega;

    public PedidosTO() {
    }

    public PedidosTO(Long idPedido, Long idUsuario, LocalDate dataPedido, String status, Double totalPedido, String tipoTransacao, LocalDate dataEntrega) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.dataPedido = dataPedido;
        this.status = status;
        this.totalPedido = totalPedido;
        this.tipoTransacao = tipoTransacao;
        this.dataEntrega = dataEntrega;
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

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}


