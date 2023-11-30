package entidades;

import java.util.Date;
import java.util.Objects;

public class Produto {

	private String descricaoProduto;
	private CategoriaProduto categoria;
	private Date dataFabricacao;
	private double valorDeCompra;
	private double valorDeVenda;
	private Estoque estoque;

	public Produto() {
	};

	public Produto(String descricaoProduto, CategoriaProduto categoria, Date dataFabricacao, double valorDeCompra,
			double valorDeVenda, Estoque estoque) {
		super();
		this.descricaoProduto = descricaoProduto;
		this.categoria = categoria;
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

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public void setDataFabricacao(Date dataFabricacao) {
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

	@Override
	public int hashCode() {
		return Objects.hash(dataFabricacao, descricaoProduto, estoque, valorDeCompra, valorDeVenda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(dataFabricacao, other.dataFabricacao)
				&& Objects.equals(descricaoProduto, other.descricaoProduto) && Objects.equals(estoque, other.estoque)
				&& Double.doubleToLongBits(valorDeCompra) == Double.doubleToLongBits(other.valorDeCompra)
				&& Double.doubleToLongBits(valorDeVenda) == Double.doubleToLongBits(other.valorDeVenda);
	}

}
