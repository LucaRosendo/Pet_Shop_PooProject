package sistemaPetShop;

public class Servico implements ServicoExecutavel {
    private String nomeServico;
	private double preco;
	private int duracaoMinutos;
    
	// Construtor padrão
 	public Servico(){}

    public Servico(String nomeServico, double preco, int duracaoMinutos) {
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public double getPreco() {
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
