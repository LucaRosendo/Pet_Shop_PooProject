package projetoSistemaPetShop;

public abstract class Pet {
    private String nome;
    private int idade;
    private int porte;
    // falta Raça
    private Cliente dono; // Dono (Cliente)
    
    // construtor padrão
 	public Pet() {}
 	
    // construtor
    public Pet(String nome, int idade, int porte, Cliente dono) {
        this.nome = nome;
        this.idade = idade;
        this.porte = porte;
        this.dono = dono;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPorte() {
        return porte;
    }

    public void setPorte(int porte) {
        this.porte = porte;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    // método abstrato a ser sobrescrito
    public abstract String getDescricao();
}
