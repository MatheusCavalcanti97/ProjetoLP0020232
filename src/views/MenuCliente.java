package views;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;
import repository.ClienteRepository;

public class MenuCliente {

	public static void menuCliente() {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  CLIENTE		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Inserir." + "\n2. Atualizar." + "\n3. Deletar." + "\n4. Listar Todos os Cliente."
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
				try {
					ClienteRepository.getInstance().inserir();
				} catch (ClienteJaCadastradoException e1) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e1.getMessage());
				} catch (CpfException e2) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e2.getMessage());
				} catch (AtributosNaoNulosNaoVaziosException e3) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e3.getMessage());
				} catch (ApenasLetrasException e4) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e4.getMessage());
				} catch (ParseException e5) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e5.getMessage());
				} catch (TelefoneException e6) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e6.getMessage());
				} catch (NullPointerException e7) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e7.getMessage());
				}
			} else if (opcaoMenu == 2) {

				try {
					ClienteRepository.getInstance().atualizar();
				} catch (ListaVaziaException e1) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e1.getMessage());
				} catch(ClienteJaCadastradoException e2) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e2.getMessage());
				} catch(AtributosNaoNulosNaoVaziosException e3) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e3.getMessage());
				} catch(CpfException e4) {
					System.out.print("\n---------------------------\n\n");
					System.out.print(e4.getMessage());
				}

			} else if (opcaoMenu == 3) {
				try {
					ClienteRepository.getInstance().deletar();
				} catch(ListaVaziaException e1) {
					
					System.out.print("\n---------------------------\n\n");
					System.out.print(e1.getMessage());
					
				} catch(ClienteJaCadastradoException e2) {
					
					System.out.print("\n---------------------------\n\n");
					System.out.println(e2.getMessage());
				}
			} else if (opcaoMenu == 4) {

				try {
					ClienteRepository.getInstance().listarTodos();
				} catch (ListaVaziaException e1) {
					System.out.print("\n---------------------------\n\n");
					System.out.println(e1.getMessage());
				}

			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}
	}

}
