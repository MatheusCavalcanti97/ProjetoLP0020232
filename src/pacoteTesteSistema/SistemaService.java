package pacoteTesteSistema;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.TelefoneException;

public class SistemaService {

	public static void main(String[] args) throws TelefoneException {
		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {
			System.out.printf("\n-------------------------------------------------------\n");
			System.out.printf("Informe uma Opção." + "\n1. Cliente." + "\n2. Funcionario."
					+ "\n3. Produto." + "\n4. Vendas." + "\n0. Sair." + "-> ");
			System.out.printf("\n-------------------------------------------------------\n");
			try {
				Scanner ler = new Scanner(System.in);
				opcaoMenu = ler.nextInt();

			} catch (InputMismatchException e) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("Caracter Inserido Incorretamente.\nTente Novamente.");
				System.out.printf("\n------------------------------------\n");
				continue;
			}

			if (opcaoMenu == 0) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("Programa Encerrado.");
				System.out.printf("\n-------------------------------------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu == 1) {
				ClienteService.menuCliente();
			} else if (opcaoMenu == 2) {
				
			} else if (opcaoMenu == 3) {
				
			}else if (opcaoMenu == 4) {
				
			}else {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("Insira uma Opção Correta para o Menu...");
				System.out.printf("\n-------------------------------------------------------\n");
			}
		}
	}

}
