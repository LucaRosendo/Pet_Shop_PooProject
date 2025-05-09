package projetoSistemaPetShop;

public class Servico {
	private int nomeServico;
	private float preco;

	// Construtor padrão
	public Servico(){}

	// construtor
	public Servico(int nomeServico, float preco) {
		this.nomeServico = nomeServico;
		this.preco = preco;
	}

	// getters e setters
	public int getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(int nomeServico) {
		this.nomeServico = nomeServico;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}