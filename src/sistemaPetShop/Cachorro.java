package sistemaPetShop;

public class Cachorro extends Pet {
    private String raca;

    public Cachorro(String nome, int idade, int porte, String raca, Cliente dono) {
        super(nome, idade, porte, dono);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String getDescricao() {
        return "Cachorro: " + getNome() + ", " + getIdade() + " anos, porte " + getPorte() + ", raça " + raca;
    }
}