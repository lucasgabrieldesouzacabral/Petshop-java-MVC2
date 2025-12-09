package br.lil.model;
import jakarta.persistence.*;
@Entity
public class Servico extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServico;
    private String servicoHorario;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
   private Funcionario funcionario;

    public Servico() {
    }
    public Servico(int idServico, String nomeItem, double precoItem, String servicoHorario, Animal animal, Funcionario funcionario) {
        super(nomeItem, precoItem);
        this.idServico = idServico;
        this.servicoHorario = servicoHorario;
        this.animal = animal;
        this.funcionario = funcionario;
    
    }
   
    public String getServicoHorario() {
        return servicoHorario;
    }
    public void setServicoHorario(String servicoHorario) {
        this.servicoHorario = servicoHorario;
    }
   
    public String getNomeItem() {
        return super.getnomeItem();
    }
    public void setNomeItem(String nomeItem) {
        super.setNomeItem(nomeItem);
    }
   
    public double getPrecoItem() {
        return super.getprecoItem();
    }
    public void setPrecoItem(double precoItem) {
        super.setPrecoItem(precoItem);
    }
    
    public int getIdServico() {
        return idServico;
    }
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String descricaoCompleta() {
        return "Serviço: " + getnomeItem() + " - Horário: " + servicoHorario + " - R$" + getprecoItem();
    }
}