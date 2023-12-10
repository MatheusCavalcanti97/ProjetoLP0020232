package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Produto;
import entidades.Venda;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ListaVaziaException;
import util.ValidacaoIO;

public class VendaRepository {

	Scanner sc = new Scanner(System.in);

	private static VendaRepository instance;
	private List<Venda> listVendas = new ArrayList<>();

	public static synchronized VendaRepository getInstance() {

		if (instance == null) {
			instance = new VendaRepository();
		}
		return instance;
	}

	public void vender() throws ListaVaziaException, AtributosNaoNulosNaoVaziosException {

		if (ProdutoRepository.getInstance().getListProduto().size() > 0
				&& ClienteRepository.getInstance().getListCliente().size() > 0
				&& FuncionarioRepository.getInstance().getListFuncionario().size() > 0) {
			while (true) {
				Funcionario vendedor;
				Cliente cliente;
				LocalDate data = null;
				double valorTotal = 0;
				ArrayList<Produto> produtos = new ArrayList();
				Produto prod;

				if (produtos.size() > 0) {
					System.out.println("\n PRODUTOS NO CARRINHO: \n");
					double valorTotalCarrinho = 0;
					for (int i = 0; i < produtos.size(); i++) {

						System.out.println("Nome: " + produtos.get(i).getDescricaoProduto() + "	Valor: R$"
								+ produtos.get(i).getValorDeVenda() + "\n");
						valorTotalCarrinho += produtos.get(i).getValorDeVenda();
					}
					System.out.println("VALOR TOTAL: R$" + valorTotalCarrinho);

				}

				System.out.println("\nOPÇÕES:");
				System.out.println("1. ADICIONAR PRODUTOS");
				System.out.println("2. FINALIZAR VENDA");
				System.out.println("3. SAIR");

				int escolha = sc.nextInt();

				switch (escolha) {
				case 1:
					boolean vprod = true;
					while (true) {

						prod = addProduto();
						if (prod.getDescricaoProduto() == null) {
							produtos.add(prod);
						}

						break;
					}
					break;

				case 2:
					if (produtos.size() > 0) {
						for (int e = 0; e < produtos.size(); e++) {
							valorTotal += produtos.get(e).getValorDeVenda();

						}
						data = dataAtual();
						vendedor = addFuncionario();
						cliente = addCliente();
						Venda venda = new Venda(data, valorTotal, produtos, cliente, vendedor);
						listVendas.add(venda);
					} else {
						System.out.println("NENHUM PRODUTO ADICIONADO NA VENDA.\n");
					}

					break;

				case 3:
					break;

				default:
					System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE. \n");
				}
				if (escolha == 3 || escolha == 2) {
					break;
				}
			}
		} else {
			System.out.println("PARA REALIZAR UMA VENDA É PRECISO TER PRODUTO, FUNCIONÁRIO E CLIENTE CADASTRADO. \n");

		}

	}

	public void listarTodos() {
		if (this.listVendas.size() == 0) {
			System.out.println("NEMHUMA VENDA CADASTRADA!\n");

		} else {
			for (int i = 0; i < listVendas.size(); i++) {
				System.out.println(listVendas.get(i).toString() + "\n\n");
			}
		}
	}

	private Produto addProduto() {

		Produto prod = new Produto();

		System.out.print("PROCURAR PRODUTO PELO NOME: ");
		sc.nextLine();
		String nomeProduto = sc.nextLine();
		for (int i = 0; i < ProdutoRepository.getInstance().getListProduto().size(); i++) {

			if (nomeProduto
					.equalsIgnoreCase(ProdutoRepository.getInstance().getListProduto().get(i).getDescricaoProduto())) {
				prod = ProdutoRepository.getInstance().getListProduto().get(i);
				break;

			} else {
				System.out.print("PRODUTO NÃO ENCONTRADO!\n");
			}

		}
		return prod;
	}

	private LocalDate dataAtual() {
		return LocalDate.now();
	}

	private Funcionario addFuncionario() {
		Funcionario func = new Funcionario();
		System.out.println("TODOS OS FUNCIONÁRIOS CADASTRADOS: \n");
		for (int i = 0; i < FuncionarioRepository.getInstance().getListFuncionario().size(); i++) {
			System.out.println("NOME: " + FuncionarioRepository.getInstance().getListFuncionario().get(i).getNome()
					+ "MATRICULA: " + FuncionarioRepository.getInstance().getListFuncionario().get(i).getMatriculaFunc()
					+ "\n");

		}

		while (true) {
			System.out.println("DIGITE O NOME DO FUNCIONARIO QUE ESTÁ REALIZANDO A VENDA: ");
			String nFunc = sc.nextLine();
			for (int i = 0; i < FuncionarioRepository.getInstance().getListFuncionario().size(); i++) {
				if (nFunc.equalsIgnoreCase(FuncionarioRepository.getInstance().getListFuncionario().get(i).getNome())) {
					func = FuncionarioRepository.getInstance().getListFuncionario().get(i);
					break;
				}

			}
			System.out.println("FUNCIONÁRIO NÃO ENCONTRADO \n");
			System.out.println("USAR FUNCIONÁRIO NULL? S/N \n");
			String brk = sc.nextLine();
			if (brk.equalsIgnoreCase("S")) {
				break;
			} else if (brk.equalsIgnoreCase("N")) {
				continue;
			} else {
				System.out.println("RESPOSTA INVÁLIDA!");
			}

		}
		return func;
	}

	private Cliente addCliente() {

		Cliente cli = new Cliente();

		System.out.println("TODOS OS CLIENTES CADASTRADOS: \n");

		for (int i = 0; i < ClienteRepository.getInstance().getListCliente().size(); i++) {
			System.out.println("NOME: " + ClienteRepository.getInstance().getListCliente().get(i).getNome() + "CPF: "
					+ ClienteRepository.getInstance().getListCliente().get(i).getCpfPessoa() + "\n");

		}

		while (true) {
			System.out.println("DIGITE O NOME DO Cliente QUE ESTÁ REALIZANDO A CONPRA: ");
			String nFunc = sc.nextLine();
			for (int i = 0; i < ClienteRepository.getInstance().getListCliente().size(); i++) {
				if (nFunc.equalsIgnoreCase(ClienteRepository.getInstance().getListCliente().get(i).getNome())) {
					cli = ClienteRepository.getInstance().getListCliente().get(i);
					break;
				}

			}
			System.out.println("CLIENTE NÃO ENCONTRADO \n");
			System.out.println("USAR CLIENTE NULL? S/N \n");
			String brk = sc.nextLine();
			if (brk.equalsIgnoreCase("S")) {
				break;
			} else if (brk.equalsIgnoreCase("N")) {
				continue;
			} else {
				System.out.println("RESPOSTA INVÁLIDA!");
			}

		}
		return cli;
	}
}
