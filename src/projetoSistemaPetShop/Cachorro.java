package projetoSistemaPetShop;

public class Cachorro extends Pet {

	public Cachorro(String nome, int idade, int porte, Cliente dono) {
        super(nome, idade, porte, dono);
    }

    @Override // sobrescrevendo
    public String getDescricao() {
        return "Cachorro: " + getNome() + ", " + getIdade() + " anos, porte " + getPorte();
    }
}