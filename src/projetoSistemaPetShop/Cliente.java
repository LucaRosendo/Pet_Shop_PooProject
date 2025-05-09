package projetoSistemaPetShop;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private List<Pet> pets; // lista de pets
	
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	// método de adicionar um pet a lista do cliente
    public void adicionarPet(Pet pet) {
        if (pet != null) {
            pets.add(pet);
            System.out.println("Pet adicionado com sucesso ao cliente: " + nome);
        }
    }

    // método de listar os pets do cliente
    public void listarPets() {
        if (pets.isEmpty()) {
            System.out.println("Este cliente não possui pets cadastrados.");
        } else {
            System.out.println("Pets do cliente " + nome + ":");
            for (Pet pet : pets) {
            	System.out.println("- ");
                System.out.println("- " + pet.getDescricao());
            }
        }
    }
}
