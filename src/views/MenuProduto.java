package views;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.EstoqueNaoCadastradoException;
import exceptionsClass.ExclusaoNaoPermitidaProdutoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.ProdutoNaoEncontradoCadastradoException;
import repository.ProdutoRepository;

public class MenuProduto {

	public static void menuProduto() {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  PRODUTO		");
				System.out.print("\n---------------------------\n");
				System.out.print(
						"\n1. Inserir." + "\n2. Deletar." + "\n3. Listar Todos os Produtos." + "\n0. Sair." + "-> ");

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

				try {
					ProdutoRepository.getInstance().inserir();
				} catch (AtributosNaoNulosNaoVaziosException e1) {
					System.out.print("\n---------------------------\n");
					System.out.print(e1.getMessage());
				} catch (ParseException e2) {
					System.out.print("\n---------------------------\n");
					System.out.print(e2.getMessage());
				} catch (EstoqueNaoCadastradoException e3) {
					System.out.print("\n---------------------------\n");
					System.out.print(e3.getMessage());
				}

			} else if (opcaoMenu == 2) {
				try {
					ProdutoRepository.getInstance().deletar();
				} catch (ListaVaziaException e1) {
					System.out.print("\n---------------------------\n");
					System.out.print(e1.getMessage());
				} catch (ExclusaoNaoPermitidaProdutoException e2) {
					System.out.print("\n---------------------------\n");
					System.out.print(e2.getMessage());
				} catch (ProdutoNaoEncontradoCadastradoException e3) {
					System.out.print("\n---------------------------\n");
					System.out.print(e3.getMessage());
				}
			} else if (opcaoMenu == 3) {
				try {
					ProdutoRepository.getInstance().listarTodos();
				} catch (ListaVaziaException ex1) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex1.getMessage());
				}
			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}
	}

}
