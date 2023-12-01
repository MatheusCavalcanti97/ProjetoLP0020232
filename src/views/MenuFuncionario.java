package views;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import repository.FuncionarioRepository;

public class MenuFuncionario {

	public static void menuFuncionario() throws CpfException, AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException, ApenasLetrasException, ParseException {

		Integer opcaoMenu2 = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				@SuppressWarnings("resource")
				Scanner ler = new Scanner(System.in);
				System.out.print("	  FUNCIONARIO		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Inserir." + "\n2. Atualizar." + "\n3. Deletar." + "\n4. Listar Todos os Funcionários."
						+ "\n0. Sair." + "-> ");

				opcaoMenu2 = ler.nextInt();
				System.out.print("\n---------------------------\n");
			} catch (InputMismatchException e) {
				System.out.print("\n---------------------------\n");
				System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
				System.out.print("\nTENTE NOVAMENTE.");
				System.out.print("\n---------------------------\n");
				continue;
			}

			if (opcaoMenu2 == 0) {
				System.out.print("\n---------------------------\n");
				System.out.print("RETORNANDO PRO MENU ANTERIOR.");
				System.out.print("\n---------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu2 == 1) {

				FuncionarioRepository.getInstance().inserir();
				
			} else if (opcaoMenu2 == 2) {

				FuncionarioRepository.getInstance().atualizar();
				
			} else if (opcaoMenu2 == 3) {

				FuncionarioRepository.getInstance().deletar();

			} else if (opcaoMenu2 == 4) {

				FuncionarioRepository.getInstance().listarTodos();

				
			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}
	}
}
