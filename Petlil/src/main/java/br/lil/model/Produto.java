package br.lil.model;
import jakarta.persistence.*;
@Entity
public class Produto extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
   private String descricao;
   @ManyToOne
   @JoinColumn(name = "cliente_id")
   private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "petshop_id")
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