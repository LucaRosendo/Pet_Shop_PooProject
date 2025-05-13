package sistemaPetShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private List<Cliente> clientes = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
    	Main petshop = new Main();
    	
    	while (true) {
    		System.out.println("\n--- MENU PETSHOP ---");
            System.out.print("[1] - Gerenciamento de Clientes\n"
                    + "[2] - Gerenciamento de Pets\n"
                    + "[3] - Agendamendo de Serviços\n"
                    + "[4] - Sair\nRESPOSTA: ");
            int opcao = petshop.scanner.nextInt();
        	petshop.scanner.nextLine();
        	
        	switch (opcao) {
            case 1:
            	petshop.menuCliente();
                break;
            case 2:
            	petshop.menuPet();
                break;
            case 3:
            	petshop.menuServico();
                break;
            case 4:
            	petshop.fecharPrograma();
            	return;
            default:
                System.out.println("\nOPÇÃO INVÁLIDA!");
        	}
    	}
    }
    
    private void menuCliente() {
    	System.out.println("\n--- MENU CLIENTES ---");
        System.out.print("[1] - Cadastrar Cliente\n"
                + "[2] - Remover Cliente\n"
                + "[3] - Listar Cliente\n"
                + "[4] - Sair\nRESPOSTA: ");
        int opcao = scanner.nextInt();
    	scanner.nextLine();
    	
    	switch (opcao) {
        case 1:
        	novoCliente();
            break;
        case 2:
        	removerCliente();
            break;
        case 3:
        	listarClientes();
            break;
        case 4:
        	return;
        default:
            System.out.println("\nOPÇÃO INVÁLIDA!");
            menuCliente();
    	}
		
	}
    
    private void novoCliente() {
    	System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        
        clientes.add(new Cliente(nome, cpf, telefone));
        System.out.println("\nCliente adicionado.");
	}
    
    private void removerCliente() {
    	if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado para remover.");
            return;
        }

        System.out.print("\nInforme o CPF do cliente que deseja remover: ");
        String cpf = scanner.nextLine();
        
        Cliente clienteRemovido = null;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteRemovido = cliente;
                break;
            }
        }
        
        if (clienteRemovido != null) {
            clientes.remove(clienteRemovido);
            System.out.println("\nCliente: '" + clienteRemovido.getNome() + "' removido com sucesso.");
        } else {
            System.out.println("\nCliente com CPF informado não encontrado.");
        }
    }
    
    private void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado.");
        } else {
            System.out.println("\n--- LISTA DE CLIENTES ---");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("-------------------------");
            }
        }
    }


	private void menuPet() {
		
		System.out.println("\nDigite o CPF do cliente: ");
	    String cpf = scanner.nextLine();

	    Cliente clienteEncontrado = null;

	    for (Cliente cliente : clientes) {
	        if (cliente.getCpf().equals(cpf)) {
	            clienteEncontrado = cliente;
	            break;
	        }
	    }

	    if (clienteEncontrado == null) {
	        System.out.println("Cliente não encontrado com esse CPF.");
	        return;
	    }

	    System.out.println("\n--- MENU DE PETS DO CLIENTE: " + clienteEncontrado.getNome() + " ---");
	    System.out.print("[1] - Cadastrar Pet\n"
	            + "[2] - Remover Pet\n"
	            + "[3] - Listar Pet\n"
	            + "[4] - Sair\nRESPOSTA: ");
	    int opcao = scanner.nextInt();
	    scanner.nextLine();

	    switch (opcao) {
	        case 1:
	            cadastrarPet(clienteEncontrado);
	            break;
	        case 2:
	            removerPet(clienteEncontrado);
	            break;
	        case 3:
	            listarPets(clienteEncontrado);
	            break;
	        case 4:
	            return;
	        default:
	            System.out.println("Opção inválida.");
	    }
	}
	
	private void cadastrarPet(Cliente cliente) {
	    System.out.print("Nome do pet: ");
	    String nomePet = scanner.nextLine();

	    System.out.print("Idade do pet: ");
	    int idadePet = scanner.nextInt();
	    scanner.nextLine();

	    System.out.print("Porte do pet (1 = pequeno, 2 = médio, 3 = grande): ");
	    int portePet = scanner.nextInt();
	    scanner.nextLine();

	    System.out.print("Tipo do pet (1 = Cachorro, 2 = Gato, 3 = Pássaro): ");
	    int tipo = scanner.nextInt();
	    scanner.nextLine();

	    Pet pet = null;

	    switch (tipo) {
	        case 1:
	            System.out.print("Raça do cachorro: ");
	            String racaCachorro = scanner.nextLine();
	            pet = new Cachorro(nomePet, idadePet, portePet, racaCachorro, cliente);
	            break;
	        case 2:
	            System.out.print("Raça do gato: ");
	            String racaGato = scanner.nextLine();
	            pet = new Gato(nomePet, idadePet, portePet, racaGato, cliente);
	            break;
	        case 3:
	            pet = new Passaro(nomePet, idadePet, portePet, cliente);
	            break;
	        default:
	            System.out.println("Tipo inválido.");
	            return;
	    }

	    cliente.adicionarPet(pet);
	    System.out.println("Pet cadastrado com sucesso!");
	}
	
	private void removerPet(Cliente cliente) {
	    System.out.print("Digite o nome do pet a ser removido: ");
	    String nome = scanner.nextLine();

	    boolean removido = cliente.removerPet(nome);
	    if (removido) {
	        System.out.println("Pet " + nome + " removido com sucesso!");
	    } else {
	        System.out.println("Pet com esse nome não encontrado.");
	    }
	}
	
	private void listarPets(Cliente cliente) {
	    List<Pet> pets = cliente.getPets();

	    if (pets.isEmpty()) {
	        System.out.println("Este cliente não possui pets cadastrados.");
	    } else {
	        System.out.println("\n--- LISTA DE PETS ---");
	        for (Pet pet : pets) {
	            System.out.println(pet.getDescricao());
	        }
	        System.out.println("---------------------");
	    }
	}

    
    private void menuServico() {
    	System.out.println("\n--- MENU AGENDAMENTO DE SERVIÇOS ---");
	
	}

	private void fecharPrograma() {
        System.out.println("Programa encerrado. Até mais!");
        scanner.close();
        System.exit(0); // Encerra o programa
	}
    
}
