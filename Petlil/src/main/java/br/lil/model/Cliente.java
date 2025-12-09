package br.lil.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonoAnimal;      
    private String donoNome; 
    private String telefone;
    private String endereco;
    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animais = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String donoNome, String endereco, int idDonoAnimal, String telefone) {
        this.donoNome = donoNome;
        this.endereco = endereco;
        this.telefone = telefone; 
        this.idDonoAnimal = idDonoAnimal; 
    }
    

    public String getNome() {
        return this.donoNome;
    }
    
    public String getDonoNome() {
        return this.donoNome;
    }

    public void setDonoNome(String donoNome) {
        this.donoNome = donoNome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public int getIdDonoAnimal() {
        return this.idDonoAnimal;
    }

    public void setIdDonoAnimal(int idDonoAnimal) {
        this.idDonoAnimal = idDonoAnimal;
    }
    
    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
        animal.setDono(this);
    }
    public List<Animal> getAnimais() {
        return this.animais;
    }
}
