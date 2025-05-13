package sistemaPetShop;

public class Gato extends Pet{
	private String raca;

	public Gato(String nome, int idade, int porte, String raca, Cliente dono) {
        super(nome, idade, porte, dono);
        this.raca = raca;
    }
	
	public String getRaca() {
        return raca;
    }

    @Override
    public String getDescricao() {
        return "Gato: " + getNome() + ", " + getIdade() + " anos, porte " + getPorte() + ", raça " + raca;
    }
}


