package br.lil.model;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeItem;
    private double precoItem;

    public Item() {
    }
    
    public Item(String nomeItem, double precoItem) {
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
    }

    public String getnomeItem() { return nomeItem; }
    public void setNomeItem(String nomeItem) { this.nomeItem = nomeItem; }
    
    public double getprecoItem() { return precoItem; }
    public void setPrecoItem(double precoItem) { this.precoItem = precoItem; }


    public String descricaoCompleta() {
        return getnomeItem() + " - R$" + getprecoItem();
    }
}