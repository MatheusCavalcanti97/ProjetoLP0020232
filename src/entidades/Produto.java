package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Produto {

	private String descricaoProduto;
	private Date dataFabricacao;
	private double valorDeCompra;
	private double valorDeVenda;
	private Estoque estoque;

	public Produto() {
	};

	public Produto(String descricaoProduto, Date dataFabricacao, double valorDeCompra, double valorDeVenda,
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

	public Date getDataFabricacao() {
		return dataFabricacao;
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
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataF = "";
		dataF = dateFormat.format(this.getDataFabricacao());
		return "\nNOME/DESCRICAO PRODUTO: " + this.descricaoProduto + "\nDATA DE FAB: " + dataF
				+ "\nVALOR PAGO POR UN NA COMPRA DO DISTRIBUIDOR: R$" + this.valorDeCompra + "\nVALOR FINAL O CONSUMIDOR FINAL: R$"
				+ this.valorDeVenda + "\n" + this.getEstoque().toString();
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
