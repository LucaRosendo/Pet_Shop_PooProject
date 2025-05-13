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
                System.out.println("---------------------------");
            }
        }
    }


	private void menuPet() {
		System.out.println("\n--- MENU PETS ---");
		
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
