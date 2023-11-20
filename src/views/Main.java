package views;

import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);

	public void run() {

		int opcao = 0;
		while (opcao != 4) {
			System.out.println("		MENU		");
			System.out.println("1. Opções Cliente");
			System.out.println("2. Opções Funcionário");
			System.out.println("3. Opções Produto");
			System.out.println("4. Sair");

			opcao = sc.nextInt();
			
			if (opcao == 2) {
				MenuFuncionario.getInstance().opcoesFuncionario();;
			}
		}

	}

}
