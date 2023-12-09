package views;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.ListaVaziaException;

public class Main {

	public void run() throws CpfException, AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException, ApenasLetrasException, ParseException, ListaVaziaException {
		Boolean flagMenu = true;
		Integer opcaoMenu = null;
		while (flagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.printf("\n---------------------------\n");
				System.out.println("\n	  MENU		");
				System.out.printf("\n---------------------------\n");
				System.out.printf("\n1. Opções de Cliente.");
				System.out.printf("\n2. Opções de Funcionário.");
				System.out.printf("\n3. Opcao de Estoque.");
				System.out.printf("\n4. Opções de Produto.");
				System.out.printf("\n5. Opções de Venda.");
				System.out.printf("\n0. Sair. -> ");

				opcaoMenu = ler.nextInt();
				System.out.printf("\n---------------------------\n");
			} catch (InputMismatchException e) {
				System.out.print("\n---------------------------\n");
				System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
				System.out.print("\nTENTE NOVAMENTE.");
				System.out.print("\n---------------------------\n");
				continue;
			}

			if (opcaoMenu == 0) {
				System.out.println("PROGRAMA ENCERRADO.");
				flagMenu = false;
			} else if (opcaoMenu == 1) {
				MenuCliente.menuCliente();
			} else if (opcaoMenu == 2) {
				MenuFuncionario.menuFuncionario();
			} else if (opcaoMenu == 3) {
				MenuEstoque.menuEstoque();
			} else if (opcaoMenu == 4) {
				MenuProduto.menuProduto();
			} else if (opcaoMenu == 5) {
				MenuVenda.menuProduto();
			} else if (opcaoMenu < 1 || opcaoMenu > 5) {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			} else {

			}
		}
	}
}
