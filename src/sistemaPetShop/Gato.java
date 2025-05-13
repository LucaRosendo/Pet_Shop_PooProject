package sistemaPetShop;

public class Gato extends Pet{

	public Gato(String nome, int idade, int porte, Cliente dono) {
        super(nome, idade, porte, dono);
    }

    @Override
    public String getDescricao() {
        return "Gato: " + getNome() + ", " + getIdade() + " anos, porte " + getPorte();
    }
}