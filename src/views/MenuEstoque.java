package views;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import repository.EstoqueRepository;

public class MenuEstoque {

	public static void menuEstoque() {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	ESTOQUE		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Inserir." + "\n2. Atualizar." + "\n3. Deletar."
						+ "\n4. Listar Todos os Estoques." + "\n0. Sair." + "-> ");

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
					EstoqueRepository.getInstance().inserir();
				} catch (AtributosNaoNulosNaoVaziosException e1) {
					System.out.print("\n---------------------------\n");
					System.out.print(e1.getMessage());
				} catch (EstoqueUnicoException e2) {
					System.out.print("\n---------------------------\n");
					System.out.print(e2.getMessage());
				} catch (ParseException e3) {
					System.out.print("\n---------------------------\n");
					System.out.print(e3.getMessage());
				}
			} else if (opcaoMenu == 2) {
				try {
					EstoqueRepository.getInstance().atualizar();
				} catch (ListaVaziaException e1) {
					System.out.print("\n---------------------------\n");
					System.out.print(e1.getMessage());
				} catch (AtributosNaoNulosNaoVaziosException e2) {
					System.out.print("\n---------------------------\n");
					System.out.print(e2.getMessage());
				} catch (EstoqueUnicoException e3) {
					System.out.print("\n---------------------------\n");
					System.out.print(e3.getMessage());
				}
			} else if (opcaoMenu == 3) {
				try {
					EstoqueRepository.getInstance().deletar();
				} catch (ListaVaziaException e1) {
					System.out.print("\n---------------------------\n");
					System.out.print(e1.getMessage());
				} catch (EstoqueUnicoException e2) {
					System.out.print("\n---------------------------\n");
					System.out.print(e2.getMessage());
				}
			} else if (opcaoMenu == 4) {
				try {
					EstoqueRepository.getInstance().listarTodos();
				} catch (ListaVaziaException e1) {
					System.out.print("\n---------------------------\n");
					System.out.print(e1.getMessage());
				}
			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}
	}

}
