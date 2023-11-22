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
			System.out.print("\nCASO DESEJE RETORNAR AO MENU\nANTERIOR, DIGITE UM CPF IVÁLIDO.\n");
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
				throw new CpfException("CPF INCORRETO!!\n");
			}

		}

	}

	@Override
	public void atualizar() throws ListaVaziaException, ClienteJaCadastradoException,
			AtributosNaoNulosNaoVaziosException, CpfException {

		List<Cliente> c = ClienteRepository.getInstance().listCliente;
		String buscarCliente = "";

		Integer opcaoMenu2 = null;
		boolean varFlagMenu2 = false;
		Integer indice = null;

		System.out.println(c.size());
		if (c.size() < 1) {
			throw new ListaVaziaException("NÃO HÁ CLIENTES CADASTRADOS\nNA BASE DE DADOS DO SISTEMA.\n");
		}

		System.out.print("\n---------------------------\n");
		System.out.println("\nCLIENTES CADASTRADOS");

		for (int i = 0; i < c.size(); i++) {
			System.out.print("\n----------- " + (i + 1) + "º " + "-----------\n");
			System.out.print(c.get(i).getNome() + " - Cpf: " + c.get(i).getCpfPessoa());
		}

		System.out.print("\n---------------------------\n");
		System.out.print("\nINSIRA O CPF: ");
		buscarCliente = ler.nextLine();

		for (int i = 0; i < c.size(); i++) {
			if (buscarCliente.equals(c.get(i).getCpfPessoa())) {
				varFlagMenu2 = true;
				indice = i;
				break;
			}
		}

		if (varFlagMenu2 == true) {
			while (varFlagMenu2) {

				try {
					Scanner ler = new Scanner(System.in);
					System.out.print("\n---------------------------\n");
					System.out.print("	  ATUALIZAÇÃO		");
					System.out.print("\n---------------------------\n");
					System.out.print("\n1. Atualizar Endereço." + "\n2. Atualizar Telefone." + "\n0. Sair." + "-> ");

					opcaoMenu2 = ler.nextInt();
					System.out.print("\n---------------------------\n");
				} catch (InputMismatchException e) {
					System.out.print("\n---------------------------\n");
					System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
					System.out.print("\nTENTE NOVAMENTE.");
					System.out.print("\n---------------------------\n");
					continue;
				}

				if (opcaoMenu2 == 0) {
					System.out.print("\n---------------------------\n");
					System.out.print("RETORNANDO PRO MENU ANTERIOR.");
					System.out.print("\n---------------------------\n");
					varFlagMenu2 = false;
				} else if (opcaoMenu2 == 1) {

					Endereco end = inserirEndereco();
					c.get(indice).setEndereco(end);

					System.out.print("\n---------------------------\n");
					System.out.print(" ENDEREÇO ATUALIZADO ");
					System.out.print("\n---------------------------\n");
					c.get(indice).toString();
					end = null;

				} else if (opcaoMenu2 == 2) {

				} else {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf("\nINSIRA UMA OPCAO CORRETA!\n");
					System.out.printf("\n-------------------------------------------------------\n");
				}
			}
		} else {
			throw new ClienteJaCadastradoException("CPF NÃO ENCONTRADO!\n");
		}
	}

	@Override
	public void deletar() throws ListaVaziaException, ClienteJaCadastradoException {

		List<Cliente> c = ClienteRepository.getInstance().listCliente;
		String buscarCliente = "";

		Integer opcaoMenu2 = null;
		boolean varFlagMenu2 = false;
		Integer indice = null;

		if (c.size() < 1) {
			throw new ListaVaziaException("NÃO HÁ CLIENTES CADASTRADOS\nNA BASE DE DADOS DO SISTEMA.\n");
		}

		System.out.print("\n---------------------------\n");
		System.out.println("\nCLIENTES CADASTRADOS");

		for (int i = 0; i < c.size(); i++) {
			System.out.print("\n----------- " + (i + 1) + "º " + "-----------\n");
			System.out.print(c.get(i).getNome() + " - Cpf: " + c.get(i).getCpfPessoa());
		}

		System.out.print("\n---------------------------\n");
		System.out.print("\nINSIRA O CPF: ");
		buscarCliente = ler.nextLine();

		for (int i = 0; i < c.size(); i++) {
			if (buscarCliente.equals(c.get(i).getCpfPessoa())) {
				c.remove(i);
				System.out.print("\n---------------------------\n");
				System.out.print("\n CLIENTE EXCLUÍDO \n");
				break;
			} else {
				throw new ClienteJaCadastradoException("CPF NÃO ENCONTRADO!");
			}
		}
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

	private Boolean cpfJaExiste(String cpf) throws ClienteJaCadastradoException {
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

					if (ValidacaoIO.verificacaoStringNula(estado) == false
							&& ValidacaoIO.verificacaoStringVazia(estado) == false) {

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