package br.lil.model;
public class PetshopMain {
    public static void main(String[] args) {
        
        Petshop petshop = new Petshop("PetLovers", "Liberdade, 123");
        
        Funcionario funcionario = new Funcionario("Nadir", "Atendente", 2500.0);
        Funcionario funcionario2 = new Funcionario("Albert Einstein", "Veterinário", 5000.0);
        
        Cliente cliente = new Cliente("Juliete", "Rua dos Cuscuz, 456",1, "99999-9999");
        Cliente cliente2 = new Cliente("Davi Brito", "Rua das Calabresas, 789",2, "88888-8888");
        
        Animal animal = new Animal(1, "Zaczinho", 5, "Cachorro", "Pitbull", cliente, 20.5, funcionario);
        Animal animal2 = new Animal(2, "Mimo Pingo Fahrenheit Pessoa", 3, "Gato", "Siamês", cliente2, 10.0, funcionario2);
        
        cliente.adicionarAnimal(animal);
        cliente2.adicionarAnimal(animal2);
        
        funcionario.adicionarAnimalAtendido(animal);
        funcionario2.adicionarAnimalAtendido(animal2);
        
        Servico servico = new Servico(1, "Tosa" ,150, "10:00 AM", animal, funcionario);
        Servico servico2 = new Servico(2, "Banho", 100, "11:00 AM", animal2, funcionario);
        
    
        Produto produto = new Produto(1, "Bolinha de morder", 10.0, "Bolinha de borracha para cães", cliente, petshop);
        Produto produto2 = new Produto(2, "Ração Premium 50kg", 150.0, "Ração de alta qualidade para cães adultos", cliente2, petshop);
        
        
    
        
        
        Conta conta = new Conta();
        Conta conta2 = new Conta();
        
        System.out.println("=== Petshop: " + petshop.getNome() + " ===");
        System.out.println("Nome: " + petshop.getNome() + " | Endereço: " + petshop.getEndereco());

        System.out.println("=== Clientes ===");
        System.out.println("Nome: " + cliente.getNome() + " | Telefone: " + cliente.getTelefone() + " | Endereço: " + cliente.getEndereco());
        System.out.println("Nome: " + cliente2.getNome() + " | Telefone: " + cliente2.getTelefone() + " | Endereço: " + cliente2.getEndereco());

        System.out.println("\n=== Animais ===");
        System.out.println("ID: " + animal.getIdAnimal() + " | Nome: " + animal.getNomeAnimal() + " | Dono ID: " + animal.getIdDonoAnimal() + " | Especie: " + animal.getEspecieAnimal() + " | Idade: " + animal.getIdadeAnimal() + " anos" + " | Raça: " + animal.getRacaAnimal() + " | Peso: " + animal.getPesoAnimal() + " kg" + " | Atendido por: " + animal.getfuncionarioatendido().getNomeFuncionario());
        System.out.println("ID: " + animal2.getIdAnimal() + " | Nome: " + animal2.getNomeAnimal() + " | Dono ID: " + animal2.getIdDonoAnimal() + " | Especie: " + animal2.getEspecieAnimal() + " | Idade: " + animal2.getIdadeAnimal() + " anos" + " | Raça: " + animal2.getRacaAnimal() + " | Peso: " + animal2.getPesoAnimal() + " kg" + " | Atendido por: " + animal2.getfuncionarioatendido().getNomeFuncionario());

        System.out.println("\n=== Funcionários ===");
        System.out.println("Nome: " + funcionario.getNomeFuncionario() + " | Função: " + funcionario.getFuncao() + " | Salário: R$" + funcionario.getSalario() + " | Animais Atendidos: " + funcionario.getAnimaisAtendidos().size());
        System.out.println("Nome: " + funcionario2.getNomeFuncionario() + " | Função: " + funcionario2.getFuncao() + " | Salário: R$" + funcionario2.getSalario() + " | Animais Atendidos: " + funcionario2.getAnimaisAtendidos().size());

        System.out.println("\n=== Serviços Disponíveis ===");
        System.out.println("Serviço ID: " + servico.getIdServico() + " | Nome: " + servico.getNomeItem() + " | Preço: " + servico.getPrecoItem() + " | Horário: " + servico.getServicoHorario());
        System.out.println("Serviço ID: " + servico2.getIdServico() + " | Nome: " + servico2.getNomeItem() + " | Preço: " + servico2.getPrecoItem() + " | Horário: " + servico2.getServicoHorario());

        System.out.println("\n=== Produtos Disponíveis ===");
        System.out.println("ID: " + produto.getIdProduto() + " | Nome: " + produto.getNomeItem() + " | Preço: " + produto.getPrecoItem());
        System.out.println("ID: " + produto2.getIdProduto() + " | Nome: " + produto2.getNomeItem() + " | Preço: " + produto2.getPrecoItem());

        System.out.println("\n=== Contas ===");
        System.out.println("Cliente: " + animal.getidDonoAnimal().getDonoNome() + " | Conta ID: " + conta.getIdCompra() + " | Pagamento: R$" + conta.getPagamento());
        System.out.println("Cliente: " + animal2.getidDonoAnimal().getDonoNome() + " | Conta ID: " + conta2.getIdCompra() + " | Pagamento: R$" + conta2.getPagamento());

        }
    }
