package repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Endereco;
import entidades.Telefone;
import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;
import util.ValidacaoIO;

public class ClienteRepository implements CrudClass<Cliente> {
	Scanner ler = new Scanner(System.in);

	private static ClienteRepository instance;
	private List<Cliente> listCliente = new ArrayList<>();

	public static synchronized ClienteRepository getInstance() {

		if (instance == null) {
			instance = new ClienteRepository();
		}
		return instance;
	}

	@Override
	public void inserir() throws CpfException, ClienteJaCadastradoException, AtributosNaoNulosNaoVaziosException,
			ApenasLetrasException, ParseException, TelefoneException, NullPointerException {

		Cliente c;
		String cpfC;
		String nome;
		Date dataNascimento;
		String email = null;
		Endereco endereco;
		List<Telefone> telefone = new ArrayList<>();
		Date dataCadastro;
		Endereco end = null;

		Boolean flagMenu = true;

		while (flagMenu) {

			System.out.print("\n---------------------------\n");
			System.out.print("\nINFORME O CPF: ");
			cpfC = ler.nextLine();

			if (ValidacaoIO.validaCpf(cpfC) == true && ValidacaoIO.verificacaoStringVazia(cpfC) == false) {
				if (cpfJaExiste(cpfC) == false) {

					System.out.print("\n---------------------------\n");
					System.out.print("NOME DO CLIENTE: ");
					nome = ler.nextLine();

					if (ValidacaoIO.verificacaoStringNula(nome) == false
							&& ValidacaoIO.verificacaoStringVazia(nome) == false) {
						if (ValidacaoIO.ApenasDeLetras(nome) == true) {
							dataNascimento = inserirDataNascimento();

							System.out.print("\n---------------------------\n");
							System.out.print("E-MAIL: ");
							email = ler.nextLine();

							if (ValidacaoIO.verificacaoStringVazia(email) == false) {

								end = inserirEndereco();
								telefone.add(inserirTelefoneCliente());
								dataCadastro = inserirDataCadastroCliente();
								c = new Cliente(cpfC, nome, dataNascimento, email, end, telefone, dataCadastro);

								ClienteRepository.getInstance().listCliente.add(c);

								System.out.print("\n---------------------------\n");
								System.out.print("\n     CLIENTE INSERIDO!		\n");
								System.out.print("\n---------------------------\n");
								c = null;
								flagMenu = false;
							} else {
								throw new AtributosNaoNulosNaoVaziosException(
										"O E-MAIL DO CLIENTE DEVE ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!\n");
							}

						} else {
							throw new ApenasLetrasException(
									"O NOME NÃO PODE CONTER NÚMEROS OU CARACTERES ESPECIAIS!\n");
						}
					} else {
						throw new AtributosNaoNulosNaoVaziosException(
								"O NOME DO CLIENTE DEVE ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!\n");
					}
				} else {
					throw new ClienteJaCadastradoException("CLIENTE JÁ CADASTRADO NO SISTEMA!\n");
				}
			} else {
				throw new CpfException("CPF INCORRETO!!");
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
	public List<Cliente> listarTodos() throws ListaVaziaException {
		List<Cliente> c = ClienteRepository.getInstance().listCliente;

		if (c.size() < 1) {
			throw new ListaVaziaException("NÃO HÁ CLIENTES CADASTRADOS\nNA BASE DE DADOS DO SISTEMA.");
		}

		System.out.print("\n---------------------------\n");
		System.out.print("TODOS CLIENTES INSERIDOS");
		System.out.print("\n---------------------------\n");

		for (int i = 0; i < c.size(); i++) {
			System.out.print("\n----------- " + (i + 1) + "º " + "-----------\n");
			System.out.print(c.get(i).toString());
			System.out.print("\n---------------------------\n");
		}
		return null;
	}

	public Boolean cpfJaExiste(String cpf) throws ClienteJaCadastradoException {
		Boolean b = false;
		List<Cliente> c = ClienteRepository.getInstance().listCliente;

		for (int i = 0; i < c.size(); i++) {
			if (cpf.equals(c.get(i).getCpfPessoa())) {
				b = true;
			} else {
				b = false;
			}
		}
		return b;
	}

	private static Date inserirDataNascimento() throws ParseException {
		System.out.printf("\n---------------------------\n");
		System.out.println("-- INFO DATA NASCIMENTO --");
		System.out.printf("\n---------------------------\n");

		Scanner ler = new Scanner(System.in);
		Date dataNasc = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String str;
		int dia, mes, ano;

		System.out.printf("DIA DE NASCIMENTO: ");
		dia = ler.nextInt();

		System.out.printf("MÊS DE NASCIMENTO: ");
		mes = ler.nextInt();

		System.out.printf("ANO DE NASCIMENTO: ");
		ano = ler.nextInt();

		if (ValidacaoIO.validarData(dia, mes, ano) == true) {
			str = dia + "/" + mes + "/" + ano;
			str = str.replaceAll(" ", "");

			dataNasc = formato.parse(str);

		} else {
			throw new ParseException("Data Incorreta!!", 1);
		}

		return dataNasc;
	}

	private static Endereco inserirEndereco() throws AtributosNaoNulosNaoVaziosException {

		System.out.printf("\n---------------------------\n");
		System.out.print("\n-- INFO. ENDEREÇO --");
		System.out.printf("\n---------------------------\n");
		Scanner ler = new Scanner(System.in);
		Endereco end = null;
		String nomeRua, numeroImovel, cidade, estado;

		System.out.print("RUA: ");
		nomeRua = ler.nextLine();

		if (ValidacaoIO.verificacaoStringNula(nomeRua) == false
				&& ValidacaoIO.verificacaoStringVazia(nomeRua) == false) {

			System.out.print("NÚMERO DO IMOVEL: ");
			numeroImovel = ler.nextLine();

			if (ValidacaoIO.verificacaoStringNula(numeroImovel) == false
					&& ValidacaoIO.verificacaoStringVazia(numeroImovel) == false) {

				System.out.print("NOME DA CIDADE: ");
				cidade = ler.nextLine();

				if (ValidacaoIO.verificacaoStringNula(cidade) == false
						&& ValidacaoIO.verificacaoStringVazia(cidade) == false) {

					System.out.print("NOME DO ESTADO (Apenas com duas Letras): ");
					estado = ler.nextLine();

					if (ValidacaoIO.verificacaoStringNula(nomeRua) == false
							&& ValidacaoIO.verificacaoStringVazia(nomeRua) == false) {

						end = new Endereco(nomeRua, numeroImovel, cidade, estado);
					} else {
						throw new AtributosNaoNulosNaoVaziosException(
								"OS CAMPOS DO ENDEREÇO DEVEM ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!\n");
					}
				} else {
					throw new AtributosNaoNulosNaoVaziosException(
							"OS CAMPOS DO ENDEREÇO DEVEM ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!\n");
				}
			} else {
				throw new AtributosNaoNulosNaoVaziosException(
						"OS CAMPOS DO ENDEREÇO DEVEM ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!\n");
			}
		} else {
			throw new AtributosNaoNulosNaoVaziosException(
					"OS CAMPOS DO ENDEREÇO DEVEM ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!\n");
		}

		return end;
	}

	private static Date inserirDataCadastroCliente() throws ParseException {
		Date dataInscricao = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

		String resp = dF.format(dataInscricao);
		dataInscricao = dF.parse(resp);

		return dataInscricao;
	}

	private static Telefone inserirTelefoneCliente()
			throws TelefoneException, AtributosNaoNulosNaoVaziosException, NullPointerException {
		System.out.println("\n-------------------------------------------------------");
		System.out.println("-- INFO. TELEFONE --");
		System.out.println("---------------------------------------------------------");

		Scanner ler5 = new Scanner(System.in);
		String dddTelefone = null, numeroTelefone = null;
		Telefone telefone = null;
		Integer opcaoTel = null;
		Boolean flagTel = true;

		while (flagTel) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("    INFORME UMA OPÇÃO    ");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Inserir Telefone." + "\n0. Sair." + "-> ");

				opcaoTel = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("\n---------------------------\n");
				System.out.print("\nCaracter Inserido Incorretamente.\nTente Novamente.");
				continue;
			}

			if (opcaoTel == 1) {
				System.out.print("\n---------------------------\n");
				System.out.print(
						"INFORME O DDD DO SEU NÚMERO DE TELEFONE\n(Composto 2 digitos - DIGITE APENAS NÚMEROS): ");
				dddTelefone = ler5.nextLine();

				System.out.print(
						"\nINFORME O NUMERO DO TELEFONE (Composto pelo número 9 na frente\ne mais 8 digitos - DIGITE APENAS NÚMEROS): ");
				numeroTelefone = ler5.nextLine();

				if (ValidacaoIO.verificacaoStringVazia(numeroTelefone) == false
						|| ValidacaoIO.verificacaoStringVazia(numeroTelefone) == false) {
					if (ValidacaoIO.validacaoTelefoneException(dddTelefone) == true
							&& ValidacaoIO.validacaoTelefoneException(numeroTelefone) == true) {
						String telPhone = dddTelefone + "" + numeroTelefone;
						telPhone = telPhone.replaceAll(" ", "");

						telefone = new Telefone(telPhone);

					} else {
						throw new TelefoneException("TENTE NOVAMENTE INSERIR\nUM TELEFONE VÁLIDO!");
					}
				} else {
					throw new AtributosNaoNulosNaoVaziosException(
							"O TELEFONE DO CLIENTE DEVE ESTAR\nDEVIDAMENTE PREENCHIDO CORRETAMENTE!");
				}

			} else if (opcaoTel == 0) {

				if (telefone == null) {
					throw new NullPointerException("DEVE SER CADASTRADO PELO\nMENOS 01 TELEFONE.\nTENTE NOVAMENTE.\n");

				}
				System.out.print("\n---------------------------\n");
				System.out.print("\nINSERÇÃO DE TEL. FINALIZADA!\n");
				flagTel = false;

			} else {
				System.out.print("\n---------------------------\n");
				System.out.print("Insira uma Opção Correta para o Menu...");
				System.out.printf("\n---------------------------\n");
			}

		}

		return telefone;
	}
}

//
//	public static void deletarCliente() throws Exception {
//		Scanner ler = new Scanner(System.in);
//
//		Cliente cc2 = null;
//		Cliente c = Cliente.getInstance();
//		List<Cliente> c1 = c.listarTodos();
//		String cpfC = "";
//		Boolean varFlag = false;
//		Integer opcaoAtualizao = null;
//
//		System.out.printf("\n-------------------------------------------------------\n");
//		System.out.printf("CLIENTE ENCONTRADO - PROSSEGUINDO...\n");
//		System.out.printf("\nInforme o CPF de quem Deseja Atualizar as Informações: ");
//		cpfC = ler.nextLine();
//
//		for (int i = 0; i < c1.size(); i++) {
//
//			if (c1.get(i).getCpfPessoa().equals(cpfC)) {
//				cc2 = c1.get(i);
//				varFlag = true;
//			}
//		}
//
//		System.out.printf("\n-------------------------------------------------------\n");
//		System.out.printf("\nCLIENTE ENCONTRADO - PROSSEGUINDO...\n");
//
//		if (varFlag == true) {
//			while (varFlag) {
//
//				try {
//
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf("Informe uma Opção." + "\n1. Deletar." + "\n0. Sair." + "-> ");
//					opcaoAtualizao = ler.nextInt();
//					System.out.printf("\n-------------------------------------------------------\n");
//				} catch (InputMismatchException e) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf("\nCaracter Inserido Incorretamente.\nTente Novamente.");
//					System.out.printf("\n-------------------------------------------------------\n");
//					continue;
//				}
//
//				if (opcaoAtualizao == 0) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf("\nRETORNANDO PRO MENU ANTERIOR...\n");
//					System.out.printf("\n-------------------------------------------------------\n");
//					varFlag = false;
//				} else if (opcaoAtualizao == 1) {
//
//					cc2.deletar(cc2);
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf("\nCLIENTE DELETADO COM SUCESSO...\n");
//					System.out.printf("\n-------------------------------------------------------\n");
//					varFlag = false;
//
//				} else {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf("\nopção Inserida Incorretamente.\nTente Novamente.");
//					System.out.printf("\n-------------------------------------------------------\n");
//				}
//
//			}
//		} else {
//			throw new CpfException("Cpf Incorreto.");
//		}
//	}
//
//	public static void inserirCliente() throws DataNascimentoException {
//
//		boolean flagParada = true;
//		Endereco end = null;
//
//		Cliente c1 = Cliente.getInstance();
//		Cliente c = null;
//		Endereco endereco = null;
//		Telefone telefone = null;
//
//		Date dataNasc = new Date();
//		Date dataInscricao = new Date();
//
//		String cpf = "", nome = "", str = "", email = "";
//
//		List<Telefone> telList = new ArrayList<>();
//
//		int dia = 0, mes = 0, ano = 0;
//
//		String nomeRua = null, numeroImovel = "", cidade = "", estado = "";
//
//		System.out.println("\n-------------------------------------------------------");
//		System.out.println("-- INSIRA AS INFORMAÇÕES PESSOAIS REFERENTE AO CLIENTE --");
//		System.out.println("-------------------------------------------------------");
//
//		while (flagParada) {
//
//			try {
//
//				Scanner ler2 = new Scanner(System.in);
//
//				System.out.printf("\nINSIRA O NÚMERO DO CPF (Apenas Números): ");
//				cpf = ler2.nextLine();
//
//				if (ValidacaoIO.validaCpf(cpf) == false) {
//					throw new CpfException("CPF INSERIDO INCORRETAMENTE.");
//				}
//
//				System.out.println("\n-------------------------------------------------------");
//				System.out.println("-- INSIRA AS INFORMAÇÕES DO NOME --");
//				System.out.println("-------------------------------------------------------");
//
//				System.out.printf("\nNOME COMPLETO: ");
//				nome = ler2.nextLine();
//
//				System.out.printf("\n-------------------------------------------------------\n");
//
//				dataNasc = inserirDataNascimento();
//
//				System.out.println("\n-------------------------------------------------------");
//				System.out.println("-- INSIRA AS INFORMAÇÕES DE E-MAIL --");
//				System.out.println("-------------------------------------------------------");
//				System.out.printf("\nEMAIL: ");
//				email = ler2.nextLine();
//
//				endereco = inserirEndereco();
//				telefone = inserirTelefoneCliente();
//				telList.add(telefone);
//				dataInscricao = inserirDataCadastroCliente();
//
//				c = new Cliente(cpf, nome, dataNasc, email, endereco, telList, dataInscricao);
//				c1.inserir(c);
//				// c.inserir(c);
//
//				System.out.println("\n\n-------------------------------------------------------");
//				System.out.println("-- CLIENTE INSERIDO COM SUCESSO --");
//				System.out.println("-------------------------------------------------------");
//				System.out.println(c.toString());
//				System.out.printf("\n-------------------------------------------------------\n");
//				c = null;
//				break;
//
//			} catch (ClienteJaCadastradoException | ListaVaziaException ex1) {
//
//				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//				System.out.println(ex1.getMessage());
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//			} catch (NullPointerException ex2) {
//
//				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//				System.out.println(ex2.getMessage() + "\nReinicie Todo o Processo Novamente.\n");
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//			} catch (AtributosNaoNulosNaoVaziosException ex3) {
//
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//				System.out.println(ex3.getMessage() + "\n");
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//			} catch (ParseException ex4) {
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//				System.out.println(ex4.getMessage() + "\n");
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//			} catch (EnderecoException ex5) {
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//				System.out.println(ex5.getMessage() + "\n");
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//			} catch (InputMismatchException ex6) {
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//				System.out.println("Erro ao inserir Letras para valores que devem ser Númericos.");
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//			} catch (TelefoneException ex7) {
//				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//				System.out.println(ex7.getMessage() + "\n");
//			}
//
//		}
//
//	}
//
//	private static Telefone inserirTelefoneCliente() throws TelefoneException {
//		System.out.println("\n-------------------------------------------------------");
//		System.out.println("-- INFO. TELEFONE --");
//		System.out.println("---------------------------------------------------------");
//
//		Scanner ler5 = new Scanner(System.in);
//		String dddTelefone = null, numeroTelefone = null;
//		Telefone telefone = null;
//		Integer opcaoTel = null;
//		Boolean flagTel = true;
//
//		while (flagTel) {
//
//			try {
//				Scanner ler = new Scanner(System.in);
//				System.out.printf("\n-------------------------------------------------------\n");
//				System.out.printf("\nInforme uma Opção." + "\n1. Inserir Telefone." + "\n0. Sair." + "-> ");
//
//				opcaoTel = ler.nextInt();
//				System.out.printf("\n-------------------------------------------------------\n");
//			} catch (InputMismatchException e) {
//				System.out.printf("\n-------------------------------------------------------\n");
//				System.out.printf("\nCaracter Inserido Incorretamente.\nTente Novamente.");
//				System.out.printf("\n-------------------------------------------------------\n");
//				continue;
//			}
//
//			if (opcaoTel == 1) {
//				System.out.printf(
//						"\nINFORME O DDD DO SEU NÚMERO DE TELEFONE (Composto 2 digitos - DIGITE APENAS NÚMEROS): ");
//				dddTelefone = ler5.nextLine();
//
//				System.out.printf(
//						"\nIINFORME O NUMERO DO TELEFONE (Composto pelo número 9 na frente e mais 8 digitos - DIGITE APENAS NÚMEROS): ");
//				numeroTelefone = ler5.nextLine();
//
//				if (ValidacaoIO.validacaoTelefoneException(dddTelefone) == true
//						&& ValidacaoIO.validacaoTelefoneException(numeroTelefone) == true) {
//					String telPhone = dddTelefone + "" + numeroTelefone;
//					telPhone = telPhone.replaceAll(" ", "");
//
//					telefone = new Telefone(telPhone);
//
//				} else {
//					throw new TelefoneException("TENTE NOVAMENTE INSERIR UM ENDEREÇO VÁLIDO.");
//				}
//			} else if (opcaoTel == 0) {
//				System.out.printf("\n-------------------------------------------------------\n");
//				System.out.printf("\nINSERÇÃO DE TELEFONE FINALIZADA\n");
//				System.out.printf("\n-------------------------------------------------------\n");
//				flagTel = false;
//			} else {
//				System.out.printf("\n-------------------------------------------------------");
//				System.out.printf("\nInsira uma Opção Correta para o Menu..\n");
//				System.out.printf("\n-------------------------------------------------------\n");
//			}
//
//		}
//
//		return telefone;
//
//	}
//
//	private static Date inserirDataNascimento() throws ParseException, DataNascimentoException {
//		System.out.println("\n-------------------------------------------------------");
//		System.out.println("-- INFO DATA NASCIMENTO --");
//		System.out.println("-------------------------------------------------------");
//
//		Scanner ler = new Scanner(System.in);
//		Date dataNasc = new Date();
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//		String str;
//		int dia, mes, ano;
//
//		System.out.printf("\nDIA DE NASCIMENTO: ");
//		dia = ler.nextInt();
//
//		System.out.printf("\nMÊS DE NASCIMENTO: ");
//		mes = ler.nextInt();
//
//		System.out.printf("\nANO DE NASCIMENTO: ");
//		ano = ler.nextInt();
//
//		if (ValidacaoIO.validarData(dia, mes, ano) == true) {
//			str = dia + "/" + mes + "/" + ano;
//			str = str.replaceAll(" ", "");
//			dataNasc = formato.parse(str);
//
//		} else {
//			throw new DataNascimentoException("Data Incorreta!!");
//		}
//
//		return dataNasc;
//	}
//
//	private static Endereco inserirEndereco() {
//
//		System.out.println("\n-------------------------------------------------------");
//		System.out.println("-- INFO. ENDEREÇO --");
//		System.out.println("-------------------------------------------------------");
//		Scanner ler = new Scanner(System.in);
//		Endereco end = null;
//		String nomeRua, numeroImovel, cidade, estado;
//
//		System.out.printf("\nRUA: ");
//		nomeRua = ler.nextLine();
//
//		System.out.printf("\nNÚMERO DO IMOVEL: ");
//		numeroImovel = ler.nextLine();
//
//		System.out.printf("\nNOME DA CIDADE: ");
//		cidade = ler.nextLine();
//
//		System.out.printf("\nNOME DO ESTADO (Apenas com duas Letras): ");
//		estado = ler.nextLine();
//
//		end = new Endereco(nomeRua, numeroImovel, cidade, estado);
//		return end;
//	}
//
//	private static Date inserirDataCadastroCliente() throws ParseException {
//		Date dataInscricao = new Date();
//		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
//
//		String resp = dF.format(dataInscricao);
//		dataInscricao = dF.parse(resp);
//
//		return dataInscricao;
//	}
