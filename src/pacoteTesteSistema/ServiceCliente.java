package pacoteTesteSistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Endereco;
import entidades.Telefone;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CpfException;
import exceptionsClass.DataNascimentoException;
import exceptionsClass.EnderecoException;
import exceptionsClass.TelefoneException;
import util.ValidacaoIO;

public class ServiceCliente {
	Scanner ler1 = new Scanner(System.in);

	public static void menuCliente() throws TelefoneException {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {
			System.out.println("\n------------------------------------");
			System.out.println("Informe uma Opção." + "\n1. Inserir Info Pessoais." + "\n2. Atualizar Info Cliente."
					+ "\n3. Deletar Cliente." + "\n4. Listar Cliente." + "\n0. Sair." + "-> ");
			System.out.println("------------------------------------");
			try {
				Scanner ler = new Scanner(System.in);
				opcaoMenu = ler.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("\n------------------------------------");
				System.out.println("Caracter Inserido Incorretamente.\nTente Novamente.");
				System.out.println("------------------------------------");
				continue;
			}

			if (opcaoMenu == 0) {
				System.out.println("\n------------------------------------");
				System.out.println("\nprograma Encerrado.\n");
				System.out.println("\n------------------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu == 1) {
				inserirCliente();

			} else {
				System.out.println("\n------------------------------------");
				System.out.println("\nInsira uma Opção Correta para o Menu..\n");
				System.out.println("\n------------------------------------\n");
			}
		}
	}

	public static void inserirCliente() throws TelefoneException {

		boolean flagParada = true;
		Endereco end = null;

		Cliente c = null;
		Endereco endereco = null;
		Telefone telefone = null;
		Date dataNasc = new Date();
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

				System.out.printf("Insira o Número de CPF Corretamente (Apenas Números): ");
				cpf = ler2.nextLine();

				System.out.printf("\nInforme o NOME COMPLETO do Cliente: ");
				nome = ler2.nextLine();

				dataNasc = inserirDataNascimento();

				System.out.printf("\nInforme um Email: ");
				email = ler2.nextLine();

				endereco = inserirEndereco();
				telefone = inserirTelefoneCliente();
				telList.add(telefone);

				System.out.println("-------------------------------------------------------");
				System.out.println("-- CLIENTE INSERIDO COM SUCESSO --");
				System.out.println("-------------------------------------------------------");
				c = new Cliente(cpf, nome, dataNasc, email, endereco, telList, null);
				c.inserir(c);
				break;

			} catch (CpfException ex1) {

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
		Scanner ler5 = new Scanner(System.in);
		String dddTelefone = null, numeroTelefone = null;
		Telefone telefone = null;

		System.out.printf("\nInforme o DDD do seu Número de Telefone (Composto 2 digitos - DIGITE APENAS NÚMEROS): ");
		dddTelefone = ler5.nextLine();

		System.out.printf(
				"\nInforme o Número do Telefone (Composto pelo número 9 na frente e mais 8 digitos - DIGITE APENAS NÚMEROS): ");
		numeroTelefone = ler5.nextLine();

		if (ValidacaoIO.validacaoTelefoneException(dddTelefone) == true
				&& ValidacaoIO.validacaoTelefoneException(numeroTelefone) == true) {
			String telPhone = dddTelefone + "" + numeroTelefone;
			telPhone = telPhone.replaceAll(" ", "");

			telefone = new Telefone(telPhone);

		} else {
			throw new TelefoneException("Tente Inserir Novamente um telefone.");
		}

		return telefone;

	}

	private static Date inserirDataNascimento() throws ParseException {
		Scanner ler = new Scanner(System.in);
		Date dataNasc = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String str;
		int dia, mes, ano;
		System.out.printf("\nInforme o DIA de Nascimento: ");
		dia = ler.nextInt();

		System.out.printf("\nInforme o MÊS DE Nascimento: ");
		mes = ler.nextInt();

		System.out.printf("\nInforme o ANO de Nascimento: ");
		ano = ler.nextInt();

		if (ValidacaoIO.validarData(dia, mes, ano) == true) {
			str = dia + "/" + mes + "/" + ano;
			str = str.replaceAll(" ", "");
			try {
				dataNasc = formato.parse(str);
			} catch (ParseException pe) {
				throw new ParseException("Insira uma data de Nascimento Válida", 1);
			}

		}
		return dataNasc;

	}

	private static Endereco inserirEndereco() {
		Scanner ler = new Scanner(System.in);
		Endereco end = null;
		String nomeRua, numeroImovel, cidade, estado;

		System.out.printf("\nInforme o NOME DA RUA da Residencia: ");
		nomeRua = ler.nextLine();

		System.out.printf("\nInforme o NÚMERO DO IMOVÉL da Residencia: ");
		numeroImovel = ler.nextLine();

		System.out.printf("\nInforme o NOME DA CIDADE da Residencia: ");
		cidade = ler.nextLine();

		System.out.printf("\nInforme o NOME DO ESTADO da Residencia: ");
		estado = ler.nextLine();

		end = new Endereco(nomeRua, numeroImovel, cidade, estado);
		return end;
	}

}