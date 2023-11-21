package views;

import java.util.InputMismatchException;
import java.util.Scanner;

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
				System.out.print("\n1. Inserir." + "\n2. Atualizar." + "\n3. Deletar." + "\n4. Listar Todos os Produtos."
						+ "\n0. Sair." + "-> ");

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

			} else if (opcaoMenu == 2) {

			} else if (opcaoMenu == 3) {

			} else if (opcaoMenu == 4) {

			} else {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nINSIRA UMA OPCAO CORRETA!\n");
				System.out.printf("\n-------------------------------------------------------\n");
			}
		}
	}

}
