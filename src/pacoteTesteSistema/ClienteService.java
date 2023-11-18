package pacoteTesteSistema;

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
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;
import util.ValidacaoIO;

public class ClienteService {
	Scanner ler = new Scanner(System.in);

	public static void menuCliente() {

		Integer opcaoMenu2 = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("Informe uma Opção." + "\n1. Inserir Info Pessoais." + "\n2. Atualizar Info Cliente."
						+ "\n3. Deletar Cliente." + "\n4. Listar Cliente." + "\n0. Sair." + "-> ");

				opcaoMenu2 = ler.nextInt();
				System.out.printf("\n-------------------------------------------------------\n");
			} catch (InputMismatchException e) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nCaracter Inserido Incorretamente.\nTente Novamente.");
				System.out.printf("\n-------------------------------------------------------\n");
				continue;
			}

			if (opcaoMenu2 == 0) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nRETORNANDO PRO MENU ANTERIOR...\n");
				System.out.printf("\n-------------------------------------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu2 == 1) {
				try {
					inserirCliente();
				} catch (CpfException ex1) {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf(ex1.getMessage());
					System.out.printf("\n-------------------------------------------------------\n");
				}

			} else if (opcaoMenu2 == 2) {

				try {
					atualizar();
				} catch (ListaVaziaException ex2) {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf(ex2.getMessage());
					System.out.printf("\n-------------------------------------------------------\n");
				} catch (ClienteJaCadastradoException ex1) {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf(ex1.getMessage());
					System.out.printf("\n-------------------------------------------------------\n");
				}

			} else if (opcaoMenu2 == 3) {
				deletarCliente();
			} else if (opcaoMenu2 == 4) {

				try {
					listarTodosClientes();
				} catch (ListaVaziaException e) {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf(e.getMessage());
					System.out.printf("\n-------------------------------------------------------\n");
				}

			} else {
				System.out.printf("\n-------------------------------------------------------");
				System.out.printf("\nInsira uma Opção Correta para o Menu..\n");
				System.out.printf("\n-------------------------------------------------------\n");
			}
		}
	}

	public static void listarTodosClientes() throws ListaVaziaException {

		Cliente c = Cliente.getInstance();
		List<Cliente> c1 = c.listarTodos();

		System.out.printf("\n-------------------------------------------------------");
		System.out.printf("\nTODOS CLIENTE CADASTRADOS EM NOSSA BASE DE DADOS...\n");
		System.out.printf("\n-------------------------------------------------------\n");

		for (int i = 0; i < c1.size(); i++) {
			System.out.printf(c1.get(i).toString());
		}

	}

	public static void atualizar() throws ClienteJaCadastradoException, ListaVaziaException {
		Scanner ler = new Scanner(System.in);
		
		
		String cpfC = null;
		Boolean varFlag = true;
		Integer opcaoAtualizao = null;

		System.out.printf("\n-------------------------------------------------------\n");
		System.out.printf("\nINICIANDO PROCESSO DE ATUALIZAÇÃO DE INFORMAÇÕES...\n");
		System.out.printf("\n-------------------------------------------------------\n");

		System.out.printf("\nInforme o cpf do Cliente que deseja Atualizar alguma informação: ");
		cpfC = ler.nextLine();
		
		Cliente c = Cliente.getInstance();
		
		
		if (c.cpfJaExiste(cpfC) == true) {
			Cliente clienteUpdate = c.buscarPorCpf(cpfC);
			
			System.out.printf("\n-------------------------------------------------------\n");
			System.out.printf("\nINFORMAÇÕES CORRETAS - PROSSEGUINDO...\n");
			System.out.printf("\n-------------------------------------------------------\n");

			while (varFlag) {

				try {
					
					Scanner ler2 = new Scanner(System.in);
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf("Informe uma Opção." + "\n1. AtualizarEndereco." + "\n2. Atualizar Telefone."
							+ "\n3. Atualizar E-mail." + "\n0. Sair." + "-> ");

					opcaoAtualizao = ler2.nextInt();
					System.out.printf("\n-------------------------------------------------------\n");
				} catch (InputMismatchException e) {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf("\nCaracter Inserido Incorretamente.\nTente Novamente.");
					System.out.printf("\n-------------------------------------------------------\n");
					continue;

				}

				if (opcaoAtualizao == 0) {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf("\nRETORNANDO PRO MENU ANTERIOR...\n");
					System.out.printf("\n-------------------------------------------------------\n");
					varFlag = false;
				} else if (opcaoAtualizao == 1) {

					Endereco end = inserirEndereco();
					clienteUpdate.setEndereco(end);
					clienteUpdate.atualizar(clienteUpdate);
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf("\nCLIENTE ATUALIZADO COM SUCESSO...\n");
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.println(clienteUpdate.toString());

				} else if (opcaoAtualizao == 2) {

				} else if (opcaoAtualizao == 3) {

				} else {
					System.out.printf("\n-------------------------------------------------------\n");
					System.out.printf("\nopção Inserida Incorretamente.\nTente Novamente.");
					System.out.printf("\n-------------------------------------------------------\n");
				}
			}
		}
	}

	public static void deletarCliente() {

	}

	public static void inserirCliente() {

		boolean flagParada = true;
		Endereco end = null;

		Cliente c1 = Cliente.getInstance();
		Cliente c = null;
		Endereco endereco = null;
		Telefone telefone = null;

		Date dataNasc = new Date();
		Date dataInscricao = new Date();

		String cpf = "", nome = "", str = "", email = "";

		List<Telefone> telList = new ArrayList<>();

		int dia = 0, mes = 0, ano = 0;

		String nomeRua = null, numeroImovel = "", cidade = "", estado = "";

		System.out.println("\n-------------------------------------------------------");
		System.out.println("-- INSIRA AS INFORMAÇÕES PESSOAIS REFERENTE AO CLIENTE --");
		System.out.println("-------------------------------------------------------");

		while (flagParada) {

			try {

				Scanner ler2 = new Scanner(System.in);

				System.out.printf("\nINSIRA O NÚMERO DO CPF (Apenas Números): ");
				cpf = ler2.nextLine();

				if (ValidacaoIO.validaCpf(cpf) == false) {
					throw new CpfException("CPF INSERIDO INCORRETAMENTE.");
				}

				System.out.println("\n-------------------------------------------------------");
				System.out.println("-- INSIRA AS INFORMAÇÕES DO NOME --");
				System.out.println("-------------------------------------------------------");

				System.out.printf("\nNOME COMPLETO: ");
				nome = ler2.nextLine();

				System.out.printf("\n-------------------------------------------------------\n");

				dataNasc = inserirDataNascimento();

				System.out.println("\n-------------------------------------------------------");
				System.out.println("-- INSIRA AS INFORMAÇÕES DE E-MAIL --");
				System.out.println("-------------------------------------------------------");
				System.out.printf("\nEMAIL: ");
				email = ler2.nextLine();

				endereco = inserirEndereco();
				telefone = inserirTelefoneCliente();
				telList.add(telefone);
				dataInscricao = inserirDataCadastroCliente();

				c = new Cliente(cpf, nome, dataNasc, email, endereco, telList, dataInscricao);
				c1.inserir(c);
				// c.inserir(c);

				System.out.println("\n\n-------------------------------------------------------");
				System.out.println("-- CLIENTE INSERIDO COM SUCESSO --");
				System.out.println("-------------------------------------------------------");
				System.out.println(c.toString());
				System.out.printf("\n-------------------------------------------------------\n");
				c = null;
				break;

			} catch (ClienteJaCadastradoException | ListaVaziaException ex1) {

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(ex1.getMessage());
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} catch (NullPointerException ex2) {

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(ex2.getMessage() + "\nReinicie Todo o Processo Novamente.\n");
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} catch (AtributosNaoNulosNaoVaziosException ex3) {

				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(ex3.getMessage() + "\n");
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} catch (ParseException ex4) {
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(ex4.getMessage() + "\n");
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} catch (EnderecoException ex5) {
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(ex5.getMessage() + "\n");
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} catch (InputMismatchException ex6) {
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println("Erro ao inserir Letras para valores que devem ser Númericos.");
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			} catch (TelefoneException ex7) {
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(ex7.getMessage() + "\n");
			}

		}

	}

	private static Telefone inserirTelefoneCliente() throws TelefoneException {
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
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nInforme uma Opção." + "\n1. Inserir Telefone." + "\n0. Sair." + "-> ");

				opcaoTel = ler.nextInt();
				System.out.printf("\n-------------------------------------------------------\n");
			} catch (InputMismatchException e) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nCaracter Inserido Incorretamente.\nTente Novamente.");
				System.out.printf("\n-------------------------------------------------------\n");
				continue;
			}

			if (opcaoTel == 1) {
				System.out.printf(
						"\nINFORME O DDD DO SEU NÚMERO DE TELEFONE (Composto 2 digitos - DIGITE APENAS NÚMEROS): ");
				dddTelefone = ler5.nextLine();

				System.out.printf(
						"\nIINFORME O NUMERO DO TELEFONE (Composto pelo número 9 na frente e mais 8 digitos - DIGITE APENAS NÚMEROS): ");
				numeroTelefone = ler5.nextLine();

				if (ValidacaoIO.validacaoTelefoneException(dddTelefone) == true
						&& ValidacaoIO.validacaoTelefoneException(numeroTelefone) == true) {
					String telPhone = dddTelefone + "" + numeroTelefone;
					telPhone = telPhone.replaceAll(" ", "");

					telefone = new Telefone(telPhone);

				} else {
					throw new TelefoneException("TENTE NOVAMENTE INSERIR UM ENDEREÇO VÁLIDO.");
				}
			} else if (opcaoTel == 0) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nINSERÇÃO DE TELEFONE FINALIZADA\n");
				System.out.printf("\n-------------------------------------------------------\n");
				flagTel = false;
			} else {
				System.out.printf("\n-------------------------------------------------------");
				System.out.printf("\nInsira uma Opção Correta para o Menu..\n");
				System.out.printf("\n-------------------------------------------------------\n");
			}

		}

		return telefone;

	}

	private static Date inserirDataNascimento() throws ParseException {
		System.out.println("\n-------------------------------------------------------");
		System.out.println("-- INFO DATA NASCIMENTO --");
		System.out.println("-------------------------------------------------------");

		Scanner ler = new Scanner(System.in);
		Date dataNasc = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String str;
		int dia, mes, ano;

		System.out.printf("\nDIA DE NASCIMENTO: ");
		dia = ler.nextInt();

		System.out.printf("\nMÊS DE NASCIMENTO: ");
		mes = ler.nextInt();

		System.out.printf("\nANO DE NASCIMENTO: ");
		ano = ler.nextInt();

		if (ValidacaoIO.validarData(dia, mes, ano) == true) {
			str = dia + "/" + mes + "/" + ano;
			str = str.replaceAll(" ", "");
			try {
				dataNasc = formato.parse(str);
			} catch (ParseException pe) {
				throw new ParseException("INSIRA UMA DATA VÁLIDA.", 1);
			}

		}

		return dataNasc;

	}

	private static Endereco inserirEndereco() {

		System.out.println("\n-------------------------------------------------------");
		System.out.println("-- INFO. ENDEREÇO --");
		System.out.println("-------------------------------------------------------");
		Scanner ler = new Scanner(System.in);
		Endereco end = null;
		String nomeRua, numeroImovel, cidade, estado;

		System.out.printf("\nRUA: ");
		nomeRua = ler.nextLine();

		System.out.printf("\nNÚMERO DO IMOVEL: ");
		numeroImovel = ler.nextLine();

		System.out.printf("\nNOME DA CIDADE: ");
		cidade = ler.nextLine();

		System.out.printf("\nNOME DO ESTADO (Apenas com duas Letras): ");
		estado = ler.nextLine();

		end = new Endereco(nomeRua, numeroImovel, cidade, estado);
		return end;
	}

	private static Date inserirDataCadastroCliente() throws ParseException {
		Date dataInscricao = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

		String resp = dF.format(dataInscricao);
		dataInscricao = dF.parse(resp);

		return dataInscricao;
	}

}