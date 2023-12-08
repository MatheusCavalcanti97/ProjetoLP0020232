package repository;

import java.text.DateFormat;
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
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import util.ValidacaoIO;

public class EstoqueRepository implements CrudClass<Estoque> {
	Scanner ler = new Scanner(System.in);

	private static EstoqueRepository instance;
	private List<Estoque> listEstoque = new ArrayList<>();

	public static synchronized EstoqueRepository getInstance() {

		if (instance == null) {
			instance = new EstoqueRepository();
		}
		return instance;
	}

	@Override
	public void inserir() throws AtributosNaoNulosNaoVaziosException, EstoqueUnicoException, ParseException {

		Estoque estoque = null;
		String descricaoEstoque;
		int quantidadeProduto;
		Date dataEntradaProd = new Date(374021196980L);
		Date dataSaida = new Date(374021196980L);

		String dataEntradaString = null, dataSaidaString = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		Boolean flagMenu = true;

		while (flagMenu) {
			System.out.print("\n---------------------------\n");
			System.out.print("\nNOME/DESCRIÇÃO DO ESTOQUE: ");
			descricaoEstoque = ler.nextLine();

			if (ValidacaoIO.verificacaoStringVazia(descricaoEstoque) == false
					&& ValidacaoIO.verificacaoStringNula(descricaoEstoque) == false) {
				if (this.estoqueUnico(descricaoEstoque) == false) {
					System.out.print("\n---------------------------\n");
					System.out.print("\nO VALOR INICIAL DO ESTOQUE\nÉ ZERO AO SER CADASTRADO.\n");

					quantidadeProduto = 0;
					dataEntradaProd = inserirDataCadastroEstoque();
					estoque = new Estoque(descricaoEstoque.toUpperCase(), quantidadeProduto, dataEntradaProd,
							dataSaida);
					EstoqueRepository.instance.listEstoque.add(estoque);

					System.out.print("\n---------------------------\n");
					System.out.print("\nESTOQUE INSERIDO\n");
					System.out.print("\n---------------------------\n");
					System.out.print(estoque.toString());

					estoque = null;
					flagMenu = false;

				} else {
					throw new EstoqueUnicoException("\nESTOQUE JÁ ADICIONADO NO SISTEMA!\n");
				}
			} else {
				throw new AtributosNaoNulosNaoVaziosException(
						"\nO NOME DO ESTOQUE DEVE SER\nDEVIDAMENTE PREENCHIDO.\n");
			}
		}
	}

	@Override
	public void atualizar() throws ListaVaziaException, AtributosNaoNulosNaoVaziosException, EstoqueUnicoException {

		String buscarEstoque = "";
		List<Estoque> eList = EstoqueRepository.getInstance().listEstoque;
		Integer opcaoMenu2 = null;
		boolean varFlagMenu2 = false;
		Integer indice = null;

		if (eList.size() < 1) {
			throw new ListaVaziaException("\nNÃO HÁ NENHUM ESTOQUE\nCADASTRADO SISTEMA!\n");
		}

		System.out.print("\n---------------------------\n");
		System.out.print("TODOS ESTOQUES CADASTRADOS");
		System.out.print("\n---------------------------\n\n");

		for (int i = 0; i < eList.size(); i++) {
			System.out.println((i + 1) + "º - " + eList.get(i).getDescricaoEstoque());
		}
		System.out.print("\n---------------------------\n");

		System.out.print("\n---------------------------\n");
		System.out.print("DIGITE O NOME/DESCRIÇÃO\nPARA BUSCAR O ESTOQUE: ");
		buscarEstoque = ler.nextLine();

		for (int i = 0; i < eList.size(); i++) {
			if (buscarEstoque.equalsIgnoreCase(eList.get(i).getDescricaoEstoque())) {
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
					System.out.print("\n1. Atualizar Estoque." + "\n0. Sair." + "-> ");

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

					buscarEstoque = "";
					System.out.print("\n---------------------------\n");
					System.out.print("INFORME O NOVO NOME/DESCRIÇÃO\nDO ESTOQUE P/ ATUALIZAR: ");
					buscarEstoque = ler.nextLine();

					if (this.estoqueUnico(buscarEstoque) == false) {

						eList.get(indice).setDescricaoEstoque(buscarEstoque);

						System.out.print("\n---------------------------\n");
						System.out.print(" ESTOQUE ATUALIZADO ");
						System.out.print("\n---------------------------\n");

						System.out.print(eList.get(indice).toString());
						varFlagMenu2 = false;
					} else {
						throw new EstoqueUnicoException("ESTOQUE JÁ CADASTRADO COM\nESTA DESCRIÇÃO/NOME!");
					}

					varFlagMenu2 = false;

				} else {
					System.out.print("\n---------------------------\n\n");
					System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
					System.out.print("\n---------------------------\n\n");
				}
			}

		} else {
			throw new EstoqueUnicoException("NENHUM ESTOQUE ENCONTRADO!\n");
		}

	}

	@Override
	public void deletar() throws ListaVaziaException, EstoqueUnicoException {
		Boolean varFlagMenu2 = false;
		Integer indice = null;
		String buscarEstoque = "";
		List<Estoque> eList = EstoqueRepository.getInstance().listEstoque;

		if (eList.size() < 1) {
			throw new ListaVaziaException("NÃO HÁ ESTOQUES CADASTRADOS\nNA BASE DE DADOS DO SISTEMA.\n");
		}

		System.out.print("\n---------------------------\n");
		System.out.print("TODOS ESTOQUES CADASTRADOS");
		System.out.print("\n---------------------------\n\n");

		for (int i = 0; i < eList.size(); i++) {
			System.out.println((i + 1) + "º - " + eList.get(i).getDescricaoEstoque());
		}

		System.out.print("\n---------------------------\n");
		System.out.print("\nDIGITE O NOME/DESCRIÇÃO\nPARA BUSCAR O ESTOQUE: ");
		buscarEstoque = ler.nextLine();

		for (int i = 0; i < eList.size(); i++) {

			if (buscarEstoque.equalsIgnoreCase(eList.get(i).getDescricaoEstoque())) {
				varFlagMenu2 = true;
				indice = i;
				break;
			}
		}

		if (varFlagMenu2 == true) {
			for (int i = 0; i < eList.size(); i++) {
				if (this.estoqueUnico(buscarEstoque) == true) {
					eList.remove(i);
					System.out.print("\n---------------------------\n");
					System.out.print("ESTOQUE REMOVIDO");
					break;
				}
			}

		} else {
			throw new EstoqueUnicoException("\nNENHUM ESTOQUE ENCONTRADO!\n");
		}
	}

	@Override
	public List<Estoque> listarTodos() throws ListaVaziaException {
		
		List<Estoque> eList = EstoqueRepository.getInstance().listEstoque;

		if (eList.size() < 1) {
			throw new ListaVaziaException("\nNÃO HÁ NENHUM ESTOQUE\nCADASTRADO SISTEMA!\n");
		}

		System.out.print("\n---------------------------\n");
		System.out.print("TODOS ESTOQUES INSERIDOS");
		System.out.print("\n---------------------------\n");
		Estoque e;

		for (int i = 0; i < eList.size(); i++) {

			System.out.print("\n----------- " + (i + 1) + "º " + "-----------\n");
			System.out.print(eList.get(i).toString());
			System.out.print("\n---------------------------\n");
		}
		return eList;
	}

	public boolean estoqueUnico(String a) {
		List<Estoque> eList = EstoqueRepository.instance.listEstoque;

		Boolean flagBoo = false;
		String a1 = null, b = null;
		a1 = ValidacaoIO.removeAcentos(a);

		for (int i = 0; i < eList.size(); i++) {
			b = ValidacaoIO.removeAcentos(eList.get(i).getDescricaoEstoque());
			if (a1.equalsIgnoreCase(b)) {
				flagBoo = true;
				break;
			}
		}
		return flagBoo;
	}

	private static Date inserirDataCadastroEstoque() throws ParseException {
		Date dataInscricao = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

		String resp = dF.format(dataInscricao);
		dataInscricao = dF.parse(resp);

		return dataInscricao;
	}

	public List<Estoque> getListEstoque() {
		return listEstoque;
	}
}
