package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public void run() {
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
				System.out.printf("\n0. Sair. -> ");

				opcaoMenu = ler.nextInt();
				System.out.printf("\n---------------------------\n");
			} catch (InputMismatchException e) {
				System.out.printf("\n---------------------------\n");
				System.out.printf("Caracter Inserido Incorretamente.\nTente Novamente.");
				System.out.printf("\n---------------------------\n");
				continue;
			}
			
			if(opcaoMenu == 0) {
				System.out.println("PROGRAMA ENCERRADO.");
				flagMenu = false;
			} else if (opcaoMenu == 1) {
				MenuCliente.menuCliente();
			} else if (opcaoMenu == 2) {
				MenuFuncionario.getInstance().opcoesFuncionario();
			} else if(opcaoMenu == 3) {
					MenuEstoque.menuEstoque();
			} else if(opcaoMenu == 4){
				
			} else if(opcaoMenu == 5) {
				
			} else if(opcaoMenu < 1 || opcaoMenu > 5) {
				System.out.println("Insira um opção de Menu Corretamente.");
				System.out.printf("\n---------------------------\n");
			} else {
				
			}
		}
	}
}
