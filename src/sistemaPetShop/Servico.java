package sistemaPetShop;

public class Servico implements ServicoExecutavel {
    private int nomeServico;
	private float preco;
	private int duracaoMinutos;
    
	// Construtor padrão
 	public Servico(){}

    public Servico(int nomeServico, float preco, int duracaoMinutos) {
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getNomeServico() {
        return nomeServico;
    }

    public float getPreco() {
        return preco;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public void executarServico() {
        System.out.println("Executando serviço: " + nomeServico + " | Preço: R$" + preco + " | Duração: " + duracaoMinutos + " minutos");
    }

    @Override
    public String toString() {
        return nomeServico + " (R$" + preco + ", " + duracaoMinutos + "min)";
    }
}
