package sistemaPetShop;

public abstract class Pet {
    private String nome;
    private int idade;
    private int porte;
    private Cliente dono;

    
	// construtor padrão
	public Pet() {}
  	
	// construtor
    public Pet(String nome, int idade, int porte, Cliente dono) {
        this.nome = nome;
        this.idade = idade;
        this.porte = porte;
        this.dono = dono;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPorte() {
        return porte;
    }

    public Cliente getDono() {
        return dono;
    }

 // método abstrato a ser sobrescrito
    public abstract String getDescricao();
}