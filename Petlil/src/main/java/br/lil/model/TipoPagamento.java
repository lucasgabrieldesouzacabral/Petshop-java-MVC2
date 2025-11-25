package br.lil.model;
public class TipoPagamento {
    private int idPagamento;
    private String nomePagamento;

    public TipoPagamento(int idPagamento, String nomePagamento) {
        this.idPagamento = idPagamento;
        this.nomePagamento = nomePagamento;
    }
    public int getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    public String getNomePagamento() {
        return nomePagamento;
    }
    public void setNomePagamento(String nomePagamento) {
        this.nomePagamento = nomePagamento;
    }
}