package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Estoque;
import entidades.Produto;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import util.ValidacaoIO;

public class ProdutoRepository implements CrudClass<Produto> {

	Scanner ler = new Scanner(System.in);

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
				System.out.print("	  CLIENTE		");
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
				
				if(ValidacaoIO.verificacaoStringVazia(descricaoProduto) == false && ValidacaoIO.verificacaoStringNula(descricaoProduto) == false) {
					
				} else {
					throw new AtributosNaoNulosNaoVaziosException("\nO NOME/DESCRIÇÃO DO PRODUTO\nDEVE ESTAR DEVIDAMENTE PREENCHIDO.\n");
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
	public List<Produto> listarTodos() {
		return null;
	}

}
