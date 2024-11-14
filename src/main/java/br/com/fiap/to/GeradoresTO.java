package br.com.fiap.to;

public class GeradoresTO {
    private Long idGerador;
    private Long idMarca;
    private Long idCategoria;
    private String modelo;
    private String descricao;
    private Double potencia;
    private Double capacidadeBateria;
    private String portas;
    private String tempoCarga;
    private Double precoVenda;
    private Double precoAluguelDiario;
    private String durabilidade;
    private String portatil;

    public GeradoresTO() {
    }

    public GeradoresTO(Long idGerador, Long idMarca, Long idCategoria, String modelo, String descricao, Double potencia, Double capacidadeBateria, String portas, String tempoCarga, Double precoVenda, Double precoAluguelDiario, String durabilidade, String portatil) {
        this.idGerador = idGerador;
        this.idMarca = idMarca;
        this.idCategoria = idCategoria;
        this.modelo = modelo;
        this.descricao = descricao;
        this.potencia = potencia;
        this.capacidadeBateria = capacidadeBateria;
        this.portas = portas;
        this.tempoCarga = tempoCarga;
        this.precoVenda = precoVenda;
        this.precoAluguelDiario = precoAluguelDiario;
        this.durabilidade = durabilidade;
        this.portatil = portatil;
    }

    public Long getIdGerador() {
        return idGerador;
    }

    public void setIdGerador(Long idGerador) {
        this.idGerador = idGerador;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Double getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(Double capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }

    public String getTempoCarga() {
        return tempoCarga;
    }

    public void setTempoCarga(String tempoCarga) {
        this.tempoCarga = tempoCarga;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoAluguelDiario() {
        return precoAluguelDiario;
    }

    public void setPrecoAluguelDiario(Double precoAluguelDiario) {
        this.precoAluguelDiario = precoAluguelDiario;
    }

    public String getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(String durabilidade) {
        this.durabilidade = durabilidade;
    }

    public String getPortatil() {
        return portatil;
    }

    public void setPortatil(String portatil) {
        this.portatil = portatil;
    }
}