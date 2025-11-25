package br.lil.model;

public class Produto extends Item {
    private int idProduto;
   private String descricao;
   private Cliente cliente;
   private Petshop petshop;

    public Produto(int idProduto, String nomeItem, double precoItem, String descricao, Cliente cliente, Petshop petshop) {
        super(nomeItem, precoItem);
        this.descricao = descricao;
        this.cliente = cliente;
        this.petshop = petshop;
        this.idProduto = idProduto;
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Petshop getPetshop() { return petshop; }
    public void setPetshop(Petshop petshop) { this.petshop = petshop; }

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }


}