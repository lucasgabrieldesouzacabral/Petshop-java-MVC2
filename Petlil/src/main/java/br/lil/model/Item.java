package br.lil.model;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Item {
    private String nomeItem;
    private double precoItem;

    public Item() {
    }
    
    public Item(String nomeItem, double precoItem) {
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
    }

    public String getNomeItem() { return nomeItem; }
    public void setNomeItem(String nomeItem) { this.nomeItem = nomeItem; }

    public double getPrecoItem() { return precoItem; }
    public void setPrecoItem(double precoItem) { this.precoItem = precoItem; }

    public String descricaoCompleta() {
        return getNomeItem() + " - R$" + getPrecoItem();
    }
}