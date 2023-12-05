package repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Estoque;
import entidades.Produto;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ListaVaziaException;
import util.ValidacaoIO;

public class ProdutoRepository implements CrudClass<Produto> {

	Scanner ler = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);

	private static ProdutoRepository instance;
	private List<Produto> listProduto = new ArrayList<>();

	public static synchronized ProdutoRepository getInstance() {

		if (instance == null) {
			instance = new ProdutoRepository();
		}
		return instance;
	}

	@Override
	public void inserir() throws AtributosNaoNulosNaoVaziosException {
		if (EstoqueRepository.getInstance().getListEstoque().size() == 0) {
			System.out.println("Nenhum estoque criado!");
			System.out.println("Crie primeiro um estoque para poder cadastrar um produto. \n");
		} else {

			Produto prod = null;
			String descricaoProduto;
			Date dataFabricacao;
			double valorDeCompra = 0., valorDeVenda = 0.;
			Estoque estoque;

			Boolean flagMenu = true;
			Integer opcaoMenu = null;

			while (flagMenu) {

				try {
					Scanner ler = new Scanner(System.in);
					System.out.print("\n---------------------------\n");
					System.out.print("	  Produto		");
					System.out.print("\n---------------------------\n");
					System.out.print("\n1. Continuar Processor de Inserção." + "\n0. Sair." + "-> ");

					opcaoMenu = ler.nextInt();
					System.out.print("\n---------------------------\n");
				} catch (InputMismatchException e) {
					System.out.print("\n---------------------------\n");
					System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
					System.out.print("\nTENTE NOVAMENTE.");
					System.out.print("\n---------------------------\n");
					continue;
				}

				if (opcaoMenu == 0) {
					System.out.print("\n---------------------------\n");
					System.out.print("RETORNANDO PRO MENU ANTERIOR.");
					System.out.print("\n---------------------------\n");
					flagMenu = false;
				} else if (opcaoMenu == 1) {

					System.out.print("\n---------------------------\n");
					System.out.println("NOME/DESCRIÇÃO PRODUTO: ");
					descricaoProduto = ler.nextLine();

					while (true) {
						if (ValidacaoIO.verificacaoStringVazia(descricaoProduto) == false
								&& ValidacaoIO.verificacaoStringNula(descricaoProduto) == false) {
							break;

						} else {
							throw new AtributosNaoNulosNaoVaziosException(
									"\nO NOME/DESCRIÇÃO DO PRODUTO\nDEVE ESTAR DEVIDAMENTE PREENCHIDO.\n");
						}

					}
					while (true) {
						try {
							dataFabricacao = DataFabricacao();
							break;

						} catch (java.text.ParseException e) {
							System.out.println("Data incorreta");
						}
						System.out.println("\n---------------------------\n");
					}

					while (true) {
						try {
							System.out.println("		Valor de Compra		");
							System.out.println("Valor: R$");
							valorDeCompra = sc.nextDouble();
							sc.nextLine();
							break;

						} catch (java.util.InputMismatchException e2) {
							sc.nextLine();
							System.out.println("valor inválido!");
							System.out.println("\n---------------------------\n");
						}
					}

					while (true) {
						try {
							System.out.println("		valorDeVenda		");
							System.out.println("Valor: R$");
							valorDeVenda = sc.nextDouble();
							sc.nextLine();
							break;

						} catch (java.util.InputMismatchException e2) {
							sc.nextLine();
							System.out.println("valor inválido!");
							System.out.println("\n---------------------------\n");
						}
					}

					while (true) {
						System.out.println("\n---------------------------\n");
						System.out.println("		Estoque		");
						if (EstoqueRepository.getInstance().getListEstoque().size() == 0) {
							System.out.println("Nenhum estoque criado!");
							System.out.println("Crie primeiro um estoque para poder cadastrar um produto \n");

							break;
						} else {
							try {
								EstoqueRepository.getInstance().listarTodos();
							} catch (ListaVaziaException e) {
								e.printStackTrace();
							}
							System.out.println("\n Digite o nome do estoque que deseja adicionar o produto: \n");
							String nomeEstoq = sc.nextLine();

							for (int i = 0; i < EstoqueRepository.getInstance().getListEstoque().size(); i++) {

								if (EstoqueRepository.getInstance().getListEstoque().get(i).getDescricaoEstoque()
										.equalsIgnoreCase(nomeEstoq)) {
									int quant = 0;
									while (true) {
										try {
											System.out.println("\n Digite a quantidade do produto: ");
											quant = sc.nextInt();
											sc.nextLine();
											EstoqueRepository.getInstance().getListEstoque().get(i)
													.setQuantidadeProduto(quant);
											break;
										} catch (InputMismatchException e) {
											sc.nextLine();
											System.out.println("\n Quantidade inválida! \n");
										}

									}
									prod = new Produto(descricaoProduto, dataFabricacao, valorDeCompra, valorDeVenda,
											EstoqueRepository.getInstance().getListEstoque().get(i));
									System.out.println("\n Produto cadastrado! \n");

									break;
								}

							}

						}

					}

				} else {
					System.out.print("\n---------------------------\n\n");
					System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
					System.out.print("\n---------------------------\n\n");
				}

			}
		}

	}

	@Override
	public void atualizar() {

	}

	@Override
	public void deletar() {

	}

	@Override
	public List<Produto> listarTodos() {
		return null;
	}

	private Date DataFabricacao() throws ParseException {
		System.out.println("-- INFO DATA NASCIMENTO --");
		System.out.printf("\n---------------------------\n");

		Date data = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String str;
		boolean pass = true;
		boolean pass1 = true;

		int dia = 0;
		int mes = 0;
		int ano = 0;
		while (pass) {
			while (pass1) {
				try {
					System.out.printf("DIA: ");
					dia = sc.nextInt();

					System.out.printf("MÊS: ");
					mes = sc.nextInt();

					System.out.printf("ANO: ");
					ano = sc.nextInt();
					sc.nextLine();
					pass1 = false;
				} catch (java.util.InputMismatchException e1) {
					System.out.println("Data inválida!");
					sc.nextLine();
				}
			}

			if (ValidacaoIO.validarData(dia, mes, ano) == true) {
				str = dia + "/" + mes + "/" + ano;
				str = str.replaceAll(" ", "");

				data = formato.parse(str);
				pass = false;

			} else {
				throw new ParseException("Data Incorreta!!", 1);
			}
		}
		return data;
	}

}
