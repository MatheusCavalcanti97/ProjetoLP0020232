package repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Estoque;
import entidades.Produto;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.EstoqueNaoCadastradoException;
import exceptionsClass.ExclusaoNaoPermitidaProdutoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.ProdutoNaoEncontradoCadastradoException;
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
	public void inserir() throws AtributosNaoNulosNaoVaziosException, ParseException, EstoqueNaoCadastradoException {
		if (EstoqueRepository.getInstance().getListEstoque().size() == 0) {
			System.out.print("\n---------------------------\n");
			System.out.println("\nNENHUM ESTOQUE CRIADO!");
			System.out.print("CRIE PRIMEIRO UM ESTOQUE PARA\nPODER CADASTRAR UM PRODUTO!\n");
		} else {

			Produto prod = null;
			String descricaoProduto;
			Date dataFabricacao, dataSaida;
			double valorDeCompra = 0., valorDeVenda = 0.;
			Estoque estoque;

			Boolean flagMenu = true;
			Integer opcaoMenu = null;

			while (flagMenu) {

				try {
					Scanner ler = new Scanner(System.in);
					System.out.print("\n---------------------------\n");
					System.out.print("	INSERÇÃO DE PRODUTO		");
					System.out.print("\n---------------------------\n");
					System.out.print("\n1. Continuar Processo de Inserção?" + "\n0. Sair." + "-> ");

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
							System.out.print("\n---------------------------\n");
							dataFabricacao = DataFabricacao();
							break;

						} catch (java.text.ParseException e) {
							System.out.println("\nDATA INVÁLIDA!\n");
						}
						System.out.println("\n---------------------------\n");
					}

					while (true) {
						try {
							System.out.print("\n---------------------------\n");
							System.out.print("DIGITE O VALOR DE COMPRA PARA REVENDA: ");
							valorDeCompra = sc.nextDouble();
							sc.nextLine();
							break;
						} catch (java.util.InputMismatchException e2) {
							sc.nextLine();
							System.out.println("\nVALOR INVÁLIDO!\n");
							System.out.println("\n---------------------------\n");
						}
					}

					while (true) {
						try {
							System.out.print("\n---------------------------\n");
							System.out.print("DIGITE O VALOR DE VENDA: ");
							valorDeVenda = sc.nextDouble();
							sc.nextLine();
							break;

						} catch (java.util.InputMismatchException e2) {
							sc.nextLine();
							System.out.println("\nVALOR INVÁLIDO!\n!");
							System.out.println("\n---------------------------\n");
						}
					}

					while (true) {
						System.out.println("\n---------------------------\n");
						System.out.println("     ESTOQUE		");
						if (EstoqueRepository.getInstance().getListEstoque().size() == 0) {
							System.out.print("\nNENHUM ESTOQUE CADASTRADO.\n");
							System.out.print("\nCRIE PRIMEIRO UM ESTOQUE\nPARA PODER CADASTRAR UM PRODUTO!\n");

							break;
						} else {
							try {
								System.out.print("\n---------------------------\n");
								System.out.print("\nSELECIONE UM ESTOQUE");
								EstoqueRepository.getInstance().listarTodos();
							} catch (ListaVaziaException e) {
								e.printStackTrace();
							}

							System.out.print("\n---------------------------\n");
							System.out.println(
									"\nDIGITE O NOME DO ESTOQUE QUE DESEJA\nSELECIONAR PARA SER O DO PRODUTO: ");
							String nomeEstoq = sc.nextLine();

							for (int i = 0; i < EstoqueRepository.getInstance().getListEstoque().size(); i++) {

								if (EstoqueRepository.getInstance().getListEstoque().get(i).getDescricaoEstoque()
										.equalsIgnoreCase(nomeEstoq)) {
									int quant = 0;
									while (true) {
										try {
											System.out.print("\n---------------------------\n");
											System.out.println("\nDIGITE A QUANTIDADE DO PRODUTO: ");
											quant = sc.nextInt();
											sc.nextLine();

											dataFabricacao = inserirDataCadastroProduto();
											dataSaida = new Date(374021196980L);
											estoque = new Estoque(EstoqueRepository.getInstance().getListEstoque()
													.get(i).getDescricaoEstoque(), quant, dataFabricacao, dataSaida);
											break;
										} catch (InputMismatchException e) {
											sc.nextLine();
											System.out.println("\nQUANTIDADE INVÁLIDA!\n");
										}

									}

									prod = new Produto(descricaoProduto.toUpperCase(), dataFabricacao, valorDeCompra,
											valorDeVenda, estoque);
									ProdutoRepository.getInstance().listProduto.add(prod);
									System.out.print("\n---------------------------\n");
									System.out.println("\nPRODUTO CADASTRADO!\n");
									break;
								} else {
									throw new EstoqueNaoCadastradoException(
											"\nINSIRA UM ESTOQUE COM A DESCRIÇÃO/NOME CORRETAMENTE\nPARA INSERIR UM PRODUTO!\n");
								}
							}
						}
						break;
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
		System.out.printf("\n---------------------------\n");
		System.out.println("MÉTODO NÃO IMPLEMENTADO!");

	}

	@Override
	public void deletar()
			throws ListaVaziaException, ExclusaoNaoPermitidaProdutoException, ProdutoNaoEncontradoCadastradoException {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	EXCLUIR PRODUTO");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Deseja de Fato executar esta ação?" + "\n0. Sair." + "-> ");

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
				varFlagMenu = false;
			} else if (opcaoMenu == 1) {
				String nomeProduto = "";
				List<Produto> pList = ProdutoRepository.instance.listProduto;

				if (pList.size() < 1) {
					throw new ListaVaziaException("\nNÃO HÁ PRODUTOS CADASTRADOS!\n");
				}

				System.out.print("\n---------------------------\n");
				System.out.print("INFORME O NOME DO PRODUTO PARA SER EXCLUÍDO: ");
				nomeProduto = ler.nextLine();

				for (int i = 0; i < pList.size(); i++) {
					if (ValidacaoIO.removeAcentos(nomeProduto).toUpperCase().equalsIgnoreCase(
							ValidacaoIO.removeAcentos(pList.get(i).getDescricaoProduto()).toUpperCase())) {
						if (pList.get(i).getEstoque().getQuantidadeProduto() == 0) {
							pList.remove(i);
							break;
						} else {
							throw new ExclusaoNaoPermitidaProdutoException(
									"\nO PRODUTO NÃO PODE SER EXCLUÍDO\nENQUANTO HOUVER UNIDADES\nDISPONIVEIS EM ESTOQUE!\n");
						}
					} else {
						throw new ProdutoNaoEncontradoCadastradoException("\nPRODUTO NÃO ENCONTRADO!\n");
					}
				}

			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}

	}

	@Override
	public List<Produto> listarTodos() throws ListaVaziaException {
		List<Produto> pList = ProdutoRepository.instance.listProduto;

		if (pList.size() < 1) {
			throw new ListaVaziaException("\nNÃO HÁ PRODUTOS CADASTRADOS!\n");
		}
		System.out.printf("\n---------------------------\n");
		System.out.println("LISTA DE PRODUTO(S) CADASTRADO(S)");
		System.out.printf("\n---------------------------\n");

		for (int i = 0; i < pList.size(); i++) {
			System.out.println((i + 1) + "º - " + pList.get(i).toString());
			System.out.printf("\n---------------------------\n");
		}

		return pList;
	}

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

	private Date DataFabricacao() throws ParseException {
		System.out.println("-- INFO DATA DE FABRICACAO --");
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

	private static Date inserirDataCadastroProduto() throws ParseException {
		Date dataInscricao = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

		String resp = dF.format(dataInscricao);
		dataInscricao = dF.parse(resp);

		return dataInscricao;
	}
}
