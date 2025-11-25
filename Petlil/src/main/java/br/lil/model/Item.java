package br.lil.model;
public class Item {
    private String nomeItem;
    private double precoItem;

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