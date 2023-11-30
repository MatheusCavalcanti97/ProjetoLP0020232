package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CategoriaProdutoException;
import exceptionsClass.ListaVaziaException;
import repository.CategoriaProdutoRepository;

public class MenuCategoriaProduto {

	public static void menuCategoriaProduto() {
		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print(" CATEGORIA DE PRODUTOS		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Inserir." + "\n2. Atualizar." + "\n3. Deletar."
						+ "\n4. Listar Todas as Categorias." + "\n0. Sair." + "-> ");

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
					CategoriaProdutoRepository.getInstance().inserir();
				} catch (ApenasLetrasException ex1) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex1.getMessage());
				} catch (AtributosNaoNulosNaoVaziosException ex2) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex2.getMessage());
				} catch (CategoriaProdutoException ex3) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex3.getMessage());
				}
			} else if (opcaoMenu == 2) {

			} else if (opcaoMenu == 3) {

			} else if (opcaoMenu == 4) {
				try {
					CategoriaProdutoRepository.getInstance().listarTodos();
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
