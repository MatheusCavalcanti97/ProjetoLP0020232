package pacoteTesteSistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceSistema {

	public static void main(String[] args) {
		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {
			System.out.println("\n------------------------------------");
			System.out.println("Informe uma Opção." + "\n1. Opção Cliente" + "\n2. Opcao Funcionario."
					+ "\n3. Opcao Produto" + "\n4. Opcao Venda" + "\n0. Sair." + "-> ");
			System.out.println("------------------------------------");
			try {
				Scanner ler = new Scanner(System.in);
				opcaoMenu = ler.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("\n------------------------------------");
				System.out.println("Caracter Inserido Incorretamente.\nTente Novamente.");
				System.out.println("\n------------------------------------");
				continue;
			}

			if (opcaoMenu == 0) {
				System.out.println("\n------------------------------------");
				System.out.println("\nprograma Encerrado.\n");
				System.out.println("\n------------------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu == 1) {
				MainClassCliente.menuCliente();
			} else {
				System.out.println("\n------------------------------------");
				System.out.println("\nInsira uma Opção Correta para o Menu..\n");
				System.out.println("\n------------------------------------\n");
			}
		}
	}

}
