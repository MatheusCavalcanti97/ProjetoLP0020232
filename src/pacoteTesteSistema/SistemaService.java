package pacoteTesteSistema;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.TelefoneException;

public class SistemaService {

	public static void main(String[] args) throws TelefoneException {
		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {
			System.out.println("\n------------------------------------");
			System.out.println("Informe uma Opção." + "\n1. Cliente." + "\n2. Funcionario."
					+ "\n3. Produto." + "\n4. Vendas." + "\n0. Sair." + "-> ");
			System.out.println("------------------------------------");
			try {
				Scanner ler = new Scanner(System.in);
				opcaoMenu = ler.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("\n\n------------------------------------");
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
				ClienteService.menuCliente();;
			} else if (opcaoMenu == 2) {
				
			} else if (opcaoMenu == 3) {
				
			}else if (opcaoMenu == 4) {
				
			}else {
				System.out.println("\n------------------------------------");
				System.out.println("\nInsira uma Opção Correta para o Menu..\n");
				System.out.println("\n------------------------------------\n");
			}
		}
	}

}
