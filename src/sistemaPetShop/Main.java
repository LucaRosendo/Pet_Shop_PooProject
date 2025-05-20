package sistemaPetShop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import sistemaPetShop.exceptions.ClienteNaoEncontradoException;
import sistemaPetShop.exceptions.ClienteSemPetsException;
import sistemaPetShop.exceptions.PetShopException;

public class Main {
	
	private List<Cliente> clientes = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private List<Agendamento> agendamentos = new ArrayList<>();

	
    public static void main(String[] args) {
    	Main petshop = new Main();
    	
    	while (true) {
    		try {
    			System.out.println("\n--- MENU PETSHOP ---");
                System.out.print("[1] - Gerenciamento de Clientes\n"
                        + "[2] - Gerenciamento de Pets\n"
                        + "[3] - Agendamendo de Serviços\n"
                        + "[4] - Listar Agendamentos\n"
                        + "[5] - Sair\nRESPOSTA: ");
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
                	petshop.listarAgendamentos();
                    break;
                case 5:
                	petshop.fecharPrograma();
                	return;
                default:
                    System.out.println("\nOPÇÃO INVÁLIDA!");
            	}	
    		} catch (ClienteSemPetsException cspe) {
    		    System.out.println("Atenção: " + cspe.getMessage());
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
        
        // verifica se já existe algum cliente com o mesmo CPF
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Erro: Já existe um cliente cadastrado com esse CPF.");
                return;
            }
        }
        
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
        	try {
	            throw new ClienteNaoEncontradoException(cpf);
	        } catch (ClienteNaoEncontradoException cnee) {
	            System.out.println("Erro: " + cnee.getMessage());
	        }
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


	private void menuPet() throws ClienteSemPetsException {
		
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
	        try {
	            throw new ClienteNaoEncontradoException(cpf);
	        } catch (ClienteNaoEncontradoException cnee) {
	            System.out.println("Erro: " + cnee.getMessage());
	            return; 
	        }
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
	    System.out.println("\nPet cadastrado com sucesso!");
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
	
	private void listarPets(Cliente cliente) throws ClienteSemPetsException {
	    List<Pet> pets = cliente.getPets();

	    if (pets.isEmpty()) {
	    	throw new ClienteSemPetsException(cliente.getNome());
	    } else {
	        System.out.println("\n--- LISTA DE PETS ---");
	        for (Pet pet : pets) {
	            System.out.println(pet.getDescricao());
	        }
	        System.out.println("---------------------");
	    }
	}

    
    private void menuServico() throws ClienteSemPetsException {
    	
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
	        try {
	            throw new ClienteNaoEncontradoException(cpf);
	        } catch (ClienteNaoEncontradoException cnee) {
	            System.out.println("Erro: " + cnee.getMessage());
	            return; 
	        }
	    }
	    
	    if (clienteEncontrado.getPets().isEmpty()) {
	    	throw new ClienteSemPetsException(clienteEncontrado.getNome());
	    }
	    
	    // Mostrar pets
	    System.out.println("\nPets cadastrados:");
	    List<Pet> pets = clienteEncontrado.getPets();
	    for (int i = 0; i < pets.size(); i++) {
	        System.out.println("[" + (i + 1) + "] - " + pets.get(i).getNome());
	    }

	    System.out.print("\nEscolha o pet para agendar o serviço: ");
	    int escolhaPet = Integer.parseInt(scanner.nextLine());

	    if (escolhaPet < 1 || escolhaPet > pets.size()) {
	        System.out.println("\nOpção de pet inválida.");
	        return;
	    }

	    Pet petSelecionado = pets.get(escolhaPet - 1);
    	
	    // menu
    	System.out.println("\n--- MENU AGENDAMENTO DE SERVIÇOS ---");
        System.out.print("[1] - Agendar Banho\n"
                + "[2] - Agendar Banho e Tosa\n"
                + "[3] - Agendar Adestramento\n"
                + "[4] - Agendar Consulta Veterinaria\n"
                + "[5] - Sair\nRESPOSTA: ");
    	
    	int opcaoServico = Integer.parseInt(scanner.nextLine());
        if (opcaoServico == 5) {
            System.out.println("Saindo do menu de agendamento...");
            return;
        }

        Servico servicoEscolhido = null;
        
        switch (opcaoServico) {
        case 1:
            servicoEscolhido = new Servico("Banho", 40.0, 30);
            break;
        case 2:
            servicoEscolhido = new Servico("Banho e Tosa", 70.0, 60);
            break;
        case 3:
            servicoEscolhido = new Servico("Adestramento", 100.0, 90);
            break;
        case 4:
            servicoEscolhido = new Servico("Consulta Veterinária", 120.0, 60);
            break;
        default:
            System.out.println("\nOpção inválida.");
            return;
        }
        
        System.out.println("\nInforme a data do agendamento (formato: dd/mm/aaaa): ");
        String data = scanner.nextLine();
        
        // validação para aceitar somente datas validas, importamos 
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // // aqui ele cria um objeto SimpleDateFormat para interpretar a data no formato especificado
        formato.setLenient(false);  // para não aceitar datas invalidas

        try {
        	formato.parse(data);; // tenta validar a data, se for inválida ou fora do formato ira gerar ParseException
        } catch (ParseException e) {
        	
        	// caso aconteca o erro na conversão,vai informar o usuário e interrompee a execução do método
            System.out.println("Data inválida! Use o formato dd/mm/aaaa e uma data válida.");
            return;
        }

        try {
            Agendamento agendamento = new Agendamento(petSelecionado, servicoEscolhido, data);
            agendamento.realizarAgendamento();
            agendamentos.add(agendamento); // só adiciona se der tudo certo
        } catch (PetShopException e) {
            System.out.println("Erro ao agendar: " + e.getMessage());
        }
	}
    
    private void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("\nNenhum agendamento encontrado.");
            return;
        }

        System.out.println("\n--- LISTA DE AGENDAMENTOS ---");
        for (int i = 0; i < agendamentos.size(); i++) {
            Agendamento agendamento = agendamentos.get(i);
            System.out.println("\nAgendamento #" + (i + 1));
            System.out.println("Pet: " + agendamento.getPet().getNome());
            System.out.println("Dono: " + agendamento.getPet().getDono().getNome());
            System.out.println("Serviço: " + agendamento.getServico().getNomeServico());
            System.out.println("Data: " + agendamento.getData());
            System.out.println("Preço: R$ " + agendamento.getServico().getPreco());
            System.out.println("------------------------------");
        }
    }

	private void fecharPrograma() {
        System.out.println("Programa encerrado. Até mais!");
        scanner.close();
        System.exit(0); // Encerra o programa
	}
    
}
