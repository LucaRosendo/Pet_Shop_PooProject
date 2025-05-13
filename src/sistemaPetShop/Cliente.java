package sistemaPetShop;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	
	// construtor padrão
	public Cliente() {}
	
	// construtor
    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
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

	
}
