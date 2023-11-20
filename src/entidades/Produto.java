package entidades;

public class Produto {

	private String descricaoProduto;
	private String dataFabricacao;
	private double valorDeCompra;
	private double valorDeVenda;
	private Estoque estoque;

	public Produto() {
	};

	public Produto(String descricaoProduto, String dataFabricacao, double valorDeCompra, double valorDeVenda,
			Estoque estoque) {
		super();
		this.descricaoProduto = descricaoProduto;
		this.dataFabricacao = dataFabricacao;
		this.valorDeCompra = valorDeCompra;
		this.valorDeVenda = valorDeVenda;
		this.estoque = estoque;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public double getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(double valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public double getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}
