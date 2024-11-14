package br.com.fiap.to;

public class MarcasTO {
    private Long idMarca;
    private String nomeMarca;
    private String paisOrigem;
    private String descricao;

    public MarcasTO() {
    }

    public MarcasTO(Long idMarca, String nomeMarca, String paisOrigem, String descricao) {
        this.idMarca = idMarca;
        this.nomeMarca = nomeMarca;
        this.paisOrigem = paisOrigem;
        this.descricao = descricao;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}