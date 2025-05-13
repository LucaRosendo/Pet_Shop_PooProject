package sistemaPetShop;

public class Passaro extends Pet{

	public Passaro(String nome, int idade, int porte, Cliente dono) {
        super(nome, idade, porte, dono);
    }

    @Override
    public String getDescricao() {
        return "Passaro: " + getNome() + ", " + getIdade() + " anos, porte " + getPorte();
    }
}
