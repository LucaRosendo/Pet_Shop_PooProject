package sistemaPetShop;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private List<Pet> pets;  // Lista de pets do cliente
	
	// construtor padrão
	public Cliente() {}
	
	// construtor
    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.pets = new ArrayList<>();
    }
    
    // getters e setters

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pet> getPets() {
        return pets;
    }

    // Adicionar pet ao cliente
    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }
    
    public boolean removerPet(String nomePet) {
        for (Pet pet : pets) {
            if (pet.getNome().equalsIgnoreCase(nomePet)) {
                pets.remove(pet);
                return true;
            }
        }
        return false;
    }

    // Listar pets do cliente
    public void listarPets() {
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado para este cliente.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone;
    }
	
}
