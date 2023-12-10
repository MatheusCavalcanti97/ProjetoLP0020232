package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Venda {

	public Funcionario vendedor;
	public Cliente cliente;
	public LocalDate data;
	public double valorTotal;
	public ArrayList<Produto> produtos = new ArrayList();

	public Venda(LocalDate data, double valorTotal, ArrayList<Produto> produtos, Cliente cliente, Funcionario vendedor) {
		super();
		this.data = data;
		this.valorTotal = valorTotal;
		this.produtos = produtos;

	}

	public String toString() {

		String prods = "";

		for (int i = 0; i < produtos.size(); i++) {
			prods = "Produto: " + produtos.get(i).getDescricaoProduto() + "   Valor: "
					+ produtos.get(i).getValorDeVenda() + "\n";
		}

		return "Cliente: " + cliente.getNome() + "\nVendedor: " + vendedor.getNome() + "\nData: " + data.toString()
				+ "\nProdutos:\n" + prods + "\n Valor Total: " + valorTotal;
	}
}
