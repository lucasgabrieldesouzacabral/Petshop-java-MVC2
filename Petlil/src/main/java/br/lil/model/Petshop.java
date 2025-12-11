package br.lil.model;
import jakarta.persistence.*;

@Entity
public class Petshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPetshop;
    private String nome;
    private String endereco;

    public Petshop() {
    }

    public Petshop(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getIdPetshop() { return idPetshop; }
    public void setIdPetshop(int idPetshop) { this.idPetshop = idPetshop; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
