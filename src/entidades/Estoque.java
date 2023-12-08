package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Estoque {

	private String descricaoEstoque;
	private int quantidadeProduto;
	private Date dataEntradaProd;
	private Date dataSaida;

	public Estoque() {
	};

	public Estoque(String descricaoEstoque, int quantidadeProduto, Date dataEntradaProd, Date dataSaida) {
		super();
		this.descricaoEstoque = descricaoEstoque;
		this.quantidadeProduto = quantidadeProduto;
		this.dataEntradaProd = dataEntradaProd;
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataE = "", dataS = "";

		dataE = dateFormat.format(this.dataEntradaProd);


		return "\nNOME/DESCRIÇÃO: " + this.descricaoEstoque.toUpperCase() + "\n\nQUANTIDADE TOTAL DE ITENS\nCADASTRADO NESTA CATEGORIA: " + this.quantidadeProduto
				+ "\n\nDATA CRIAÇÃO CATEGORIA PROD.: " + dataE + "\n\nDATA SAÍDA: " + dataS;
	}

	public String getDescricaoEstoque() {
		return descricaoEstoque;
	}

	public void setDescricaoEstoque(String descricaoEstoque) {
		this.descricaoEstoque = descricaoEstoque;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Date getDataEntradaProd() {
		return dataEntradaProd;
	}

	public void setDataEntradaProd(Date dataEntradaProd) {
		this.dataEntradaProd = dataEntradaProd;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEntradaProd, dataSaida, descricaoEstoque, quantidadeProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return Objects.equals(dataEntradaProd, other.dataEntradaProd) && Objects.equals(dataSaida, other.dataSaida)
				&& Objects.equals(descricaoEstoque, other.descricaoEstoque)
				&& quantidadeProduto == other.quantidadeProduto;
	}
}