package br.lil.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
   
    public int getIdServico() { return idServico; }
    public void setIdServico(int idServico) { this.idServico = idServico; }

    public String getServicoHorario() { return servicoHorario; }
    public void setServicoHorario(String servicoHorario) { this.servicoHorario = servicoHorario; }

    public Animal getAnimal() { return animal; }
    public void setAnimal(Animal animal) { this.animal = animal; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    @Override
    public String descricaoCompleta() {
        return "Serviço: " + getnomeItem() + " - Horário: " + servicoHorario + " - R$" + getprecoItem();
    }
}