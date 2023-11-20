package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;
import modelo.CrudClass;
import modelo.IEstoque;
import util.ValidacaoIO;

public class Estoque implements CrudClass<Estoque>, IEstoque {

	private String descricaoEstoque;
	private int quantidadeProduto;
	private Date dataEntradaProd;
	private Date dataSaída;
	private List<Estoque> listaEstoque = new ArrayList<>();

	public Estoque() {
	};

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

	public List<Estoque> getListaEstoque() {
		return listaEstoque;
	}

	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
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

	@Override
	public void inserir(Estoque e)
			throws AtributosNaoNulosNaoVaziosException, NullPointerException, EstoqueUnicoException {

		if (e != null) {
			if (this.estoqueUnico(e.getDescricaoEstoque()) == false) {
				this.listaEstoque.add(e);
			} else {
				throw new EstoqueUnicoException(
						"NÃO É PERMITIDA A INSERÇÃO DE ESTOQUE\nCOM O MESMO NOME MAIS DE 1 VEZ!");
			}
		} else {
			throw new NullPointerException("TODAS AS INFORMAÇÕES DO ESTOQUE DEVEM\nESTAR DEVIDAMENTE PREENCHIDAS!!");
		}

	}

	@Override
	public void atualizar(Estoque e) {
		List<Estoque> eList = this.listaEstoque;
		for (int i = 0; i < eList.size(); i++) {
			if (e.getDescricaoEstoque().toUpperCase()
					.equalsIgnoreCase(eList.get(i).getDescricaoEstoque().toUpperCase())) {
				eList.get(i).setDescricaoEstoque(e.getDescricaoEstoque());
			}
		}
	}

	@Override
	public void deletar(Estoque e) throws ListaVaziaException {
		List<Estoque> eList = this.listaEstoque;
		for (int i = 0; i < eList.size(); i++) {
			if (e.getDescricaoEstoque().toUpperCase()
					.equalsIgnoreCase(eList.get(i).getDescricaoEstoque().toUpperCase())) {
				this.getListaEstoque().remove(i);
			}
		}
	}

	@Override
	public List<Estoque> listarTodos() throws ListaVaziaException {
		List<Estoque> eList = this.listaEstoque;

		if (eList.size() < 1) {
			throw new ListaVaziaException("NÃO HÁ NENHUM ESTOQUE CADASTRADO.");
		}
		return eList;
	}

	@Override
	public String toString() {
		return "Descrição do estoque: " + this.descricaoEstoque + "\nQuantidade de Produto no Estoque: "
				+ this.quantidadeProduto + "\nData de Entrada do Produto: " + this.dataEntradaProd
				+ "\nData de Saída do Produto: " + this.dataSaída + "\n";
	}

	@Override
	public boolean estoqueUnico(String a) {
		Boolean flagBoo = false;
		String a1 = null, b = null;
		a1 = ValidacaoIO.removeAcentos(a);

		List<Estoque> eList = this.listaEstoque;
		for (int i = 0; i < eList.size(); i++) {
			b = ValidacaoIO.removeAcentos(eList.get(i).getDescricaoEstoque());
			if (a1.equalsIgnoreCase(b)) {
				flagBoo = true;
				break;
			}
		}
		return flagBoo;
	}

}
