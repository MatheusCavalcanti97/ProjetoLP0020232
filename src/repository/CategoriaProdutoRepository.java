package repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.CategoriaProduto;
import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CategoriaProdutoException;
import exceptionsClass.ListaVaziaException;
import util.ValidacaoIO;

public class CategoriaProdutoRepository implements CrudClass<CategoriaProduto> {

	Scanner ler = new Scanner(System.in);
	private static CategoriaProdutoRepository instance;
	private List<CategoriaProduto> listCategoriaP = new ArrayList<>();

	public static synchronized CategoriaProdutoRepository getInstance() {

		if (instance == null) {
			instance = new CategoriaProdutoRepository();
		}
		return instance;
	}

	@Override
	public void inserir() throws ApenasLetrasException, AtributosNaoNulosNaoVaziosException, CategoriaProdutoException {

		CategoriaProduto categoriaP = null;
		String descricaoCategoria = null;

		Integer opcaoMenu;
		Boolean flagMenu = true;

		while (flagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	CATEGORIA DE PRODUTOS		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Deseja Inserir a Categoria?." + "\n0. Sair." + "-> ");

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
				System.out.print("\nINFORME O NOME DA CATEGORIA\nPARA SER ADICIONADA: ");
				descricaoCategoria = ler.nextLine();

				System.out.println(descricaoCategoria);

				if (ValidacaoIO.ApenasDeLetras(descricaoCategoria) == true) {
					if (ValidacaoIO.verificacaoStringNula(descricaoCategoria) == false
							&& ValidacaoIO.verificacaoStringVazia(descricaoCategoria) == false) {

						if (categoriaUnicaProduto(descricaoCategoria) == false) {
							categoriaP = new CategoriaProduto(descricaoCategoria);

							CategoriaProdutoRepository.getInstance().listCategoriaP.add(categoriaP);
							System.out.print("\n---------------------------\n");
							System.out.print("\n CATEGORIA INSERIDA!		\n");
							System.out.print("\n---------------------------\n");

							categoriaP = null;
							flagMenu = false;
						} else {
							throw new CategoriaProdutoException("\nCATEGORIA DE PRODUTO\nJÁ CADASTRADA!\n");
						}

					} else {
						throw new AtributosNaoNulosNaoVaziosException(
								"\nOS CAMPOS DO NOME DA CATEGORIA\nDEVE ESTAR DEVIDAMENTE PREENCIDO.\n");
					}
				} else {
					throw new ApenasLetrasException("\nO NOME DA CATEGORIA DEVE CONTER\nAPENAS LETRAS!!\n");
				}

			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
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
	public List<CategoriaProduto> listarTodos() throws ListaVaziaException {
		List<CategoriaProduto> cpList = CategoriaProdutoRepository.getInstance().listCategoriaP;
		if (cpList.size() < 1) {
			throw new ListaVaziaException("\nNÃO HÁ CATEGORIA DE PRODUTOS\nCADASTRADAS NO SISTEMA!\n");
		}
		
		System.out.print("\n---------------------------\n\n");
		System.out.print("\nCATEGORIAS CADASTRADAS\n\n");
		for (int i = 0; i < cpList.size(); i++) {
			System.out.println((i+1) + "º - " + cpList.get(i).toString());
		}

		return cpList;
	}

	private static Boolean categoriaUnicaProduto(String str) {
		List<CategoriaProduto> cpList = CategoriaProdutoRepository.getInstance().listCategoriaP;
		Boolean flag = true;
		String a = "", b = "";

		a = ValidacaoIO.removeAcentos(str);

		if (cpList.size() < 1) {
			flag = false;
		} else {
			for (int i = 0; i < cpList.size(); i++) {
				

				if (a.equalsIgnoreCase(ValidacaoIO.removeAcentos(cpList.get(i).getDescricaoProduto()))) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

}
