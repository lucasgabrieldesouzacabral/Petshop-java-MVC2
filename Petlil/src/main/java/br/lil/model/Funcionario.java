package br.lil.model;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int id;
    private String nomeFuncionario;
    private String funcao;
    private double salario;
    private List<Animal> animaisAtendidos;

    public Funcionario(String nomeFuncionario, String funcao, double salario) {
        this.nomeFuncionario = nomeFuncionario;
        this.funcao = funcao;
        this.salario = salario;
        this.animaisAtendidos = new ArrayList<>();
    }

    public void adicionarAnimalAtendido(Animal animal) {
        this.animaisAtendidos.add(animal);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNomeFuncionario() { return nomeFuncionario; }
    public void setNomeFuncionario(String nomeFuncionario) { this.nomeFuncionario = nomeFuncionario; }
    
    public String getfuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    
    public double getsalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    
    public List<Animal> getAnimaisAtendidos() { return animaisAtendidos; }
    public void setAnimaisAtendidos(List<Animal> animaisAtendidos) { this.animaisAtendidos = animaisAtendidos; }
}
