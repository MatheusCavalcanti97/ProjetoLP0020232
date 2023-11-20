package entidades;

import java.util.Date;
import java.util.Objects;

public class Estoque {

	private String descricaoEstoque;
	private int quantidadeProduto;
	private Date dataEntradaProd;
	private Date dataSaída;

	public Estoque() { };

	public Estoque(String descricaoEstoque, int quantidadeProduto, Date dataEntradaProd, Date dataSaída) {
		super();
		this.descricaoEstoque = descricaoEstoque;
		this.quantidadeProduto = quantidadeProduto;
		this.dataEntradaProd = dataEntradaProd;
		this.dataSaída = dataSaída;
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

	public Date getDataSaída() {
		return dataSaída;
	}

	public void setDataSaída(Date dataSaída) {
		this.dataSaída = dataSaída;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEntradaProd, dataSaída, descricaoEstoque, quantidadeProduto);
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
		return Objects.equals(dataEntradaProd, other.dataEntradaProd) && Objects.equals(dataSaída, other.dataSaída)
				&& Objects.equals(descricaoEstoque, other.descricaoEstoque)
				&& quantidadeProduto == other.quantidadeProduto;
	}

}
