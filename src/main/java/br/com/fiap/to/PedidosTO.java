package br.com.fiap.to;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidosTO {
    private Long idPedido;
    private Long idUsuario;
    @PastOrPresent private LocalDate dataPedido;
    @NotBlank(message = "Status é obrigatório e deve ser 'pendente' ou 'Concluido' ou 'Cancelado'") private String status;
    private Double totalPedido;
    @NotBlank(message = "TipoTransação é obrigatório e deve ser 'Venda' ou 'Aluguel' ou 'Ambos'") private String tipoTransacao;
    @FutureOrPresent private LocalDate dataEntrega;
    @Valid private ArrayList<ItensPedidoTO> itensPedido; // Lista de itens associados ao pedido

    public PedidosTO() {}

    public PedidosTO(Long idPedido, Long idUsuario, LocalDate dataPedido, String status, Double totalPedido,
                     String tipoTransacao, LocalDate dataEntrega, ArrayList<ItensPedidoTO> itensPedido) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.dataPedido = dataPedido;
        this.status = status;
        this.totalPedido = totalPedido;
        this.tipoTransacao = tipoTransacao;
        this.dataEntrega = dataEntrega;
        this.itensPedido = itensPedido;
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

    public ArrayList<ItensPedidoTO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<ItensPedidoTO> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Double calcularValorTotal(ArrayList<ItensPedidoTO> lista){
        Double valor = 0.0;
        for (ItensPedidoTO item : lista){
            item.setSubtotal(item.calcularSubtotal(item.getQuantidade(),item.getValorUnitario()));
            valor += item.getSubtotal();
        }
        return valor;
    }
}
