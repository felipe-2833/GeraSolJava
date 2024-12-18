package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ItensPedidoTO {
    private Long idItem;
    private Long idPedido;
    private Long idGerador;
    @NotNull @Positive private int quantidade;
    @NotNull @PositiveOrZero private Double valorUnitario;
    @NotBlank(message = "TipoTransação é obrigatório e deve ser 'Venda' ou 'Aluguel' ou 'Ambos'") private String tipoTransacao;
    private Double subtotal;

    public ItensPedidoTO() {
    }

    public ItensPedidoTO(Long idItem, Long idPedido, Long idGerador, int quantidade, Double valorUnitario, String tipoTransacao, Double subtotal) {
        this.idItem = idItem;
        this.idPedido = idPedido;
        this.idGerador = idGerador;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipoTransacao = tipoTransacao;
        this.subtotal = subtotal;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdGerador() {
        return idGerador;
    }

    public void setIdGerador(Long idGerador) {
        this.idGerador = idGerador;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double calcularSubtotal(int quantidade, Double valorUnitario){
        return quantidade * valorUnitario;
    }
}
