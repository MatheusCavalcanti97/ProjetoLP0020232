package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ListaVaziaException;
import repository.VendaRepository;

public class MenuVenda {

	public static void menuProduto() throws ListaVaziaException, AtributosNaoNulosNaoVaziosException {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  VENDAS		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Realizar Venda." + "\n2. Listar Todas as Vendas." + "\n0. Sair." + "-> ");

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
				
				VendaRepository.getInstance().vender();

			} else if (opcaoMenu == 2) {
				
				VendaRepository.getInstance().listarTodos();

			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}
	}

}
